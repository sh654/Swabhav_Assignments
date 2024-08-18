package com.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.models.User;
import com.mvc.models.User.Role;


public class DbUtil {

    // Method to establish a connection to the database
    public static Connection getConnection() throws Exception {
        // Adjust these parameters according to your database configuration
        String url = "jdbc:mysql://localhost:3306/aurobank";
        String user = "root";
        String password = "root";
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    // Method to validate user credentials based on username, password, and role
    public static int validateUser(String username, String password, Role role) throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ? AND role = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, role.toString()); // Use the value from the Role enum

        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
        	return rs.getInt(1);
        }
//        boolean isValid = rs.next(); // Check if the query returns any result
        rs.close();
        stmt.close();
        conn.close();

        return -1;
    }
    
    public static User getUserByUsername(String username) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            connection = DbUtil.getConnection(); // Assume you have a method to get DB connection
            String query = "SELECT user_id, username, password, role FROM Users WHERE username = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(User.Role.valueOf(rs.getString("role").toUpperCase()));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }

        return user;
    }
}