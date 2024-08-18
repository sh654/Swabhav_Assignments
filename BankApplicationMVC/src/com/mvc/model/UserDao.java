package com.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.models.User;

public class UserDao {

	public void addUser(User user) throws Exception {
        try {
            validatePassword(user.getPassword());

            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            try (Connection conn = DbUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getRole().toString());
                stmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error adding user", e);
            }
        } catch (Exception e) {
            // Rethrow the exception to be caught in the servlet/controller
            throw new Exception(e.getMessage());
        }
    }

    private void validatePassword(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Password must be at least 8 characters long.");
        }
    }
    
    public void updateCustomerProfile(int usersid, String firstName, String lastName) throws Exception {
        String sql = "UPDATE customer SET firstname = ?, lastname = ? WHERE usersid = ?";
        try (Connection conne = DbUtil.getConnection();
             PreparedStatement stmt = conne.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, usersid);
            stmt.executeUpdate();
        }
    }

    public void updateUserPassword(int usersid, String password) throws Exception {
        validatePassword(password);
        String sql = "UPDATE Users SET password = ? WHERE usersid = ?";
        try (Connection conne = DbUtil.getConnection();
             PreparedStatement stmt = conne.prepareStatement(sql)) {
            stmt.setString(1, password);
            stmt.setInt(2, usersid);
            stmt.executeUpdate();
        }
    }
}
