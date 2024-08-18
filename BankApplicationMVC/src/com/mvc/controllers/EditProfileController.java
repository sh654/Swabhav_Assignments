package com.mvc.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.UserDao;

@WebServlet("/EditProfileController")
public class EditProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        int usersid = (int) request.getSession().getAttribute("usersid");

        UserDao userDao = new UserDao();

        try {
            // Update the customer's profile and password
            userDao.updateCustomerProfile(usersid, firstName, lastName);
            userDao.updateUserPassword(usersid, password);

            // Set the updated password in session (if needed)
            request.getSession().setAttribute("password", password);

            // Redirect to Logout.jsp after successful update
            response.sendRedirect("Logout.jsp?message=Profile updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            // Redirect back to editProfile.jsp with an error message
            response.sendRedirect("editProfile.jsp?error=" + e.getMessage());
        }
    }
}
