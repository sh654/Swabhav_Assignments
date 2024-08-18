package com.mvc.model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountOperationsDao {

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

	private static int getAccountIdByNumber(String accountNumber) throws SQLException {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("SELECT accountsid FROM accounts WHERE accountsnumber = ?")) {
			stmt.setString(1, accountNumber);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("accountsid");
			} else {
				throw new SQLException("Account not found");
			}
		}
	}

	
	
	
	public static List <String>  getAccountIdByUserId(int customerId){	
            try {
            	Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT accountsnumber FROM accounts WHERE customerid = ?");
				stmt.setInt(1, customerId);
				List<String> accountids = new ArrayList<String>();
	            
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                accountids.add(rs.getString(1));
	            }        
	        return accountids; 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return Arrays.asList();
        
    }

	public void updateBalance(String accountNumber, BigDecimal amount, String transactionType,
			String receiverAccountNumber) throws SQLException {
		int accountId = getAccountIdByNumber(accountNumber);

		String sql = transactionType.equals("Debit") ? "UPDATE accounts SET balance = balance - ? WHERE accountsid = ?"
				: "UPDATE accounts SET balance = balance + ? WHERE accountsid = ?";

		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setBigDecimal(1, amount);
			stmt.setInt(2, accountId);
			stmt.executeUpdate();

			if (receiverAccountNumber == null) {
				recordTransactionForSelf(conn, accountId, transactionType, amount);
			} else {
				recordTransaction(conn, accountId, transactionType, amount, receiverAccountNumber);
			}
		}
	}

	public void transferAmount(String accountNumber, String receiverAccountNumber, BigDecimal amount)
			throws SQLException {
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);

			// Debit from source account
			updateBalance(accountNumber, amount, "Debit", receiverAccountNumber);

			// Credit to destination account
			updateBalance(receiverAccountNumber, amount, "Credit", accountNumber);

			conn.commit();
		} catch (SQLException e) {
			conn.rollback(); // Roll back the transaction on failure
			throw e;
		} finally {
			conn.setAutoCommit(true); // Restore auto-commit mode
			conn.close(); // Close the connection
		}
	}

	private static void recordTransactionForSelf(Connection conn, int accountId, String transactionType,
			BigDecimal amount) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO transactions (accountsid, transaction_type, amount, receiver_account_number, Date) VALUES (?, ?, ?, NULL, CURRENT_TIMESTAMP)")) {
			stmt.setInt(1, accountId);
			stmt.setString(2, transactionType);
			stmt.setBigDecimal(3, amount);
			stmt.executeUpdate();
		}
	}

	private static void recordTransaction(Connection conn, int accountId, String transactionType, BigDecimal amount,
			String receiverAccountNumber) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO transactions (accountsid, transaction_type, amount, receiver_account_number, Date) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)")) {
			stmt.setInt(1, accountId);
			stmt.setString(2, transactionType);
			stmt.setBigDecimal(3, amount);
			stmt.setString(4, receiverAccountNumber);
			stmt.executeUpdate();
		}
	}
}
