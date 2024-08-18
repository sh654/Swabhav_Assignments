package com.mvc.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.DbUtil;
import com.mvc.models.User; // Make sure this import is correct for your project

import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleStr = request.getParameter("role");

        try {
            User.Role role = User.Role.valueOf(roleStr.toUpperCase());

            int isValidUser = DbUtil.validateUser(username, password, role);

            if (isValidUser != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("usersid", isValidUser);
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                if (role == User.Role.ADMIN) {
                    response.sendRedirect("admincontroller");
                } else if (role == User.Role.CUSTOMER) {
                    response.sendRedirect("customerdashboard");
                }
            } else {
                // Redirect back to the login page with an error message
                response.sendRedirect("Login.jsp?error=invalid");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.sendRedirect("Login.jsp?error=invalid_role");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Login failed due to an internal error.");
        }
    }}