package com.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.models.Transaction;

public class TransactionAdminDao {

    public List<Transaction> getAllTransactions(String sortOrder) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT t.transaction_type, t.amount, t.receiver_account_number, t.date, a.accountsnumber " +
                       "FROM aurobank.transactions t " +
                       "JOIN aurobank.accounts a ON t.accountsid = a.accountsid " +
                       "ORDER BY t.date " + (sortOrder != null && sortOrder.equals("desc") ? "DESC" : "ASC");

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionType(rs.getString("transaction_type"));
                transaction.setAmount(rs.getBigDecimal("amount"));
                transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
                transaction.setDate(rs.getTimestamp("date"));
                transaction.setAccountNumber(rs.getString("accountsnumber"));
                transactions.add(transaction);
            }
        }

        return transactions;
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
}
