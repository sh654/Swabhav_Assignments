package com.mvc.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.models.Account;

public class AccountDao {

    public void addAccount(Account account) throws Exception {
        String sql = "INSERT INTO aurobank.accounts (customerid, accountsnumber, account_type, balance) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Check if customer exists
            if (!customerExists(account.getCustomerId())) {
                throw new SQLException("Customer ID does not exist: " + account.getCustomerId());
            }

            // Validate balance
            if (account.getBalance().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Initial balance must be greater than zero.");
            }

            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountNumber());
            stmt.setString(3, account.getAccountType());
            stmt.setBigDecimal(4, account.getBalance());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Adding account failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding account", e);
        }
    }

    private boolean customerExists(int customerId) throws Exception {
        String sql = "SELECT COUNT(*) FROM aurobank.customer WHERE customer_id = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void debitAccount(int accountId, BigDecimal amount) throws SQLException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        Connection connection = null;
        PreparedStatement stmt = null;
        
        try {
            connection = DbUtil.getConnection();
            connection.setAutoCommit(false); // Disable auto-commit
            
            String query = "UPDATE aurobank.accounts SET balance = balance - ? WHERE accountsid = ?";
            stmt = connection.prepareStatement(query);
            stmt.setBigDecimal(1, amount);
            stmt.setInt(2, accountId);
            int rowsUpdated = stmt.executeUpdate();
            
            // Check if account balance is non-negative
            String balanceQuery = "SELECT balance FROM aurobank.accounts WHERE accountsid = ?";
            try (PreparedStatement balanceStmt = connection.prepareStatement(balanceQuery)) {
                balanceStmt.setInt(1, accountId);
                ResultSet rs = balanceStmt.executeQuery();
                if (rs.next()) {
                    BigDecimal newBalance = rs.getBigDecimal("balance");
                    if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                        throw new IllegalArgumentException("Account balance cannot be negative.");
                    }
                }
            }

            if (rowsUpdated == 0) {
                throw new SQLException("Account not found");
            }
            
            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback(); // Rollback on error
            }
            e.printStackTrace();
            throw e; // Rethrow the exception
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in debit operation", e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void creditAccount(int customerId, BigDecimal amount) throws SQLException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        String query = "UPDATE accounts SET balance = balance + ? WHERE customerid = ?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBigDecimal(1, amount);
            stmt.setInt(2, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error crediting account", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in credit operation", e);
        }
    }

    public void transferAmount(int senderAccountId, String receiverAccountNumber, BigDecimal amount) throws SQLException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        // Deduct amount from sender's account
        debitAccount(senderAccountId, amount);

        // Add amount to receiver's account
        String query = "UPDATE accounts SET balance = balance + ? WHERE accountsnumber = ?";
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBigDecimal(1, amount);
            stmt.setString(2, receiverAccountNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error transferring amount", e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in transfer operation", e);
        }
    }

    public Integer getAccountIdByNumber(String accountNumber) throws Exception {
        String query = "SELECT account_id FROM accounts WHERE account_number = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("account_id");
                } else {
                    return null; // Account number not found
                }
            }
        }
    }
}
