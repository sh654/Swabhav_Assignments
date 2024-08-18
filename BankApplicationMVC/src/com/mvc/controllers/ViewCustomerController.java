package com.mvc.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.model.CustomerDao;
import com.mvc.models.CustomerAccountInfo;

@WebServlet("/ViewCustomerController")
public class ViewCustomerController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        String search = request.getParameter("search");
        String filterBy = request.getParameter("filter_by");
        String sortOrder = request.getParameter("sort_order");

        try {
            List<CustomerAccountInfo> details = customerDao.getCustomerAccountDetails(search, filterBy, sortOrder);
            request.setAttribute("customerAccountList", details);
            request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error fetching customer and account details", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
