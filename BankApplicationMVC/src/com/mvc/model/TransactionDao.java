package com.mvc.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.models.Transaction;

public class TransactionDao {

    public void recordTransaction(String accountNumber, String transactionType, BigDecimal amount, String receiverAccountNumber) throws SQLException {
        String query = "INSERT INTO aurobank.transactions (accountsid, transaction_type, amount, date, receiver_accountsnumber) " +
                       "VALUES ((SELECT accountsid FROM accounts WHERE accountsnumber = ?), ?, ?, CURRENT_TIMESTAMP, ?)";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            stmt.setString(2, transactionType);
            stmt.setBigDecimal(3, amount);
            stmt.setString(4, receiverAccountNumber);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error recording transaction", e);
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found.");
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/aurobank", "root", "root");
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();

        String query = "SELECT t.transaction_type, t.amount, a.balance, t.receiver_account_number, t.Date, a.accountsnumber " +
                       "FROM aurobank.transactions t " +
                       "JOIN aurobank.accounts a ON t.accountsid = a.accountsid " +
                       "WHERE a.accountsnumber = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            System.out.println("Executing query: " + stmt);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setAmount(rs.getBigDecimal("amount"));
                transaction.setBalance(rs.getBigDecimal("balance"));
                transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
                transaction.setDate(rs.getTimestamp("Date"));
                transaction.setAccountNumber(rs.getString("accountsnumber"));
                transactions.add(transaction);
            }
        }

        return transactions;
    }
    
    
    public List<Transaction> getSortedTransactionsByAccountNumber(String accountNumber, String sortOrder) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT t.transaction_type, t.amount, a.balance, t.receiver_account_number, t.Date, a.accountsnumber " +
                       "FROM aurobank.transactions t " +
                       "JOIN aurobank.accounts a ON t.accountsid = a.accountsid " +
                       "WHERE a.accountsnumber = ? " +
                       "ORDER BY t.Date " + (sortOrder.equals("date desc") ? "DESC" : "ASC");

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setTransactionType(rs.getString("transaction_type"));
                    transaction.setAmount(rs.getBigDecimal("amount"));
                    transaction.setBalance(rs.getBigDecimal("balance"));
                    transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
                    transaction.setDate(rs.getTimestamp("Date"));
                    transaction.setAccountNumber(rs.getString("accountsnumber"));
                    transactions.add(transaction);
                }
            }
        }

        return transactions;
    }


}
