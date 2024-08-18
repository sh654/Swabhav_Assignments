package com.mvc.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mvc.models.CustomerAccountInfo;

public class CustomerAccountDao {
    public List<CustomerAccountInfo> getCustomerAccountDetails() throws SQLException {
    	 String sql = "SELECT c.customer_id, c.firstname, c.lastname, a.accountsnumber, a.balance " +
    		        "FROM aurobank.customer c LEFT JOIN aurobank.accounts a ON c.customer_id = a.customerid";
        List<CustomerAccountInfo> list = new ArrayList<>();
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CustomerAccountInfo info = new CustomerAccountInfo();
                info.setCustomerId(rs.getInt("customer_id"));
                info.setFirstName(rs.getString("firstname"));
                info.setLastName(rs.getString("lastname"));
                info.setAccountNumber(rs.getString("account_number"));
                info.setBalance(rs.getBigDecimal("balance"));
                list.add(info);
            }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
    }
}
