package com.mvc.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.UserDao;
import com.mvc.models.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao;

    public UserController() {
        super();
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleStr = request.getParameter("role");

        // Convert the role string to enum
        User.Role role = User.Role.fromString(roleStr);

        // Create a new User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        try {
            // Add the user to the database
            userDao.addUser(user);
            // Redirect to a success page if the user is added successfully
            response.sendRedirect("addNewCustomer.jsp?success=true");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();

            // Set the error message as a request attribute
            request.setAttribute("errorMessage", e.getMessage());

            // Forward back to the addNewCustomer.jsp page with the error message
            request.getRequestDispatcher("addNewCustomer.jsp").forward(request, response);
        }
    }
}
