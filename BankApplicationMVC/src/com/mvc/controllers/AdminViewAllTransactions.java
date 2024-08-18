package com.mvc.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.TransactionAdminDao;
import com.mvc.models.Transaction;

@WebServlet("/adminviewalltransactions")
public class AdminViewAllTransactions extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Transaction> transactions = null;
        String sortOrder = request.getParameter("sortOrder"); // Get sort order parameter
        
        try {
            TransactionAdminDao transactionAdminDao = new TransactionAdminDao();
            transactions = transactionAdminDao.getAllTransactions(sortOrder); // Pass sort order to DAO
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("transactions", transactions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AllTransactions.jsp");
        dispatcher.forward(request, response);
    }
}
