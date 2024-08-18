package com.mvc.controllers;

import com.mvc.model.TransactionAdminDao;
import com.mvc.model.TransactionDao;
import com.mvc.models.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ViewAllTransactionsController")
public class ViewAllTransactionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String sortOrder = request.getParameter("sortOrder");
        List<Transaction> transactions = null;

        try {
            if (accountNumber != null && !accountNumber.isEmpty()) {
                TransactionDao transactionDao = new TransactionDao();
                if (sortOrder != null && !sortOrder.isEmpty()) {
                    transactions = transactionDao.getSortedTransactionsByAccountNumber(accountNumber, sortOrder);
                } else {
                    transactions = transactionDao.getTransactionsByAccountNumber(accountNumber);
                }
            } else {
                TransactionAdminDao transactionAdminDao = new TransactionAdminDao();
                transactions = transactionAdminDao.getAllTransactions(accountNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("transactions", transactions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllTransactions.jsp");
        dispatcher.forward(request, response);
    }

}
