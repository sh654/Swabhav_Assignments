package com.mvc.controllers;

import com.mvc.model.AccountDao;
import com.mvc.model.CustomerDao;
import com.mvc.models.Account;
import com.mvc.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

@WebServlet("/CustomerAccountController")
public class CustomerAccountController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String formType = request.getParameter("form_type");

        if ("customer_form".equals(formType)) {
            // Handle customer form submission
            int userId = Integer.parseInt(request.getParameter("user_id"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String password = request.getParameter("phone");
            
            
            // Create Customer object
            Customer customer = new Customer(userId, firstName, lastName, email, password);
            customer.setUserId(userId);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPhone(password);

            CustomerDao customerDao = new CustomerDao();
            try {
                customerDao.addCustomer(customer);
                response.sendRedirect("success.jsp");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("addBankAccount.jsp?error=Error adding customer.");
            }
        } else if ("account_form".equals(formType)) {
            // Handle account form submission
            int customerId = Integer.parseInt(request.getParameter("customer_id"));
            String accountType = request.getParameter("account_type");
            BigDecimal balance = new BigDecimal(request.getParameter("balance"));

            // Generate a 10-digit account number
            String accountNumber = String.format("%010d", new Random().nextInt(1000000000));

            // Create Account object
            Account account = new Account(customerId, accountNumber, accountType, balance);

            AccountDao accountDao = new AccountDao();
            try {
                accountDao.addAccount(account);
                response.sendRedirect("success.jsp");
            }catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("addBankAccount.jsp").forward(request, response);
            }
        }
    }
}
