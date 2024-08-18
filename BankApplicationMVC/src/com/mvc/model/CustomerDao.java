package com.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.models.Customer;
import com.mvc.models.CustomerAccountInfo;

public class CustomerDao {

    // Existing method for adding a customer
    public int addCustomer(Customer customer) throws Exception {
        validateEmail(customer.getEmail());
        validatePhoneNumber(customer.getPhone());
        String sql = "INSERT INTO customer (usersid, firstname, lastname, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, customer.getUserId());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated customer_id
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding customer", e);
        }
    }

    // Method to validate email format
    private void validateEmail(String email) throws Exception {
        if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new Exception("Invalid email format.");
        }
    }

    private void validatePhoneNumber(String phone) throws Exception {
        if (!phone.matches("\\d{10}")) {
            throw new Exception("Invalid phone number. It must be a 10-digit number.");
        }
    }

    // Updated method to get customer and account details with search and filter
    public List<CustomerAccountInfo> getCustomerAccountDetails(String search, String filterBy, String sortOrder) throws Exception {
        // Base SQL query
        StringBuilder sql = new StringBuilder("SELECT c.customer_id, c.firstname, c.lastname, a.accountsnumber, a.balance FROM aurobank.customer c LEFT JOIN aurobank.accounts a ON c.customer_id = a.customerid");
        
        // Adding search condition
        if (search != null && !search.isEmpty()) {
            sql.append(" WHERE a.accountsnumber LIKE ?");
        }
        
        // Adding filter condition
        if (filterBy != null && !filterBy.isEmpty()) {
            if (sql.toString().contains("WHERE")) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE");
            }
            sql.append(" ").append(filterBy).append(" IS NOT NULL");
        }
        
        // Adding sorting order
        if (sortOrder != null && !sortOrder.isEmpty()) {
            sql.append(" ORDER BY ").append(sortOrder);
        }

        List<CustomerAccountInfo> list = new ArrayList<>();
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            // Set the search parameter if applicable
            if (search != null && !search.isEmpty()) {
                stmt.setString(index++, "%" + search + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CustomerAccountInfo info = new CustomerAccountInfo();
                    info.setCustomerId(rs.getInt("customer_id"));
                    info.setFirstName(rs.getString("firstname"));
                    info.setLastName(rs.getString("lastname"));
                    info.setAccountNumber(rs.getString("accountsnumber"));
                    info.setBalance(rs.getBigDecimal("balance"));
                    list.add(info);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Improved exception handling
            throw new SQLException("Error fetching customer and account details", e);
        }
        return list;
    }
}
