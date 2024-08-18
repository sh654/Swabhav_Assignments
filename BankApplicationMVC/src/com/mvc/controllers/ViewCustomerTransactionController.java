package com.mvc.controllers;

import com.mvc.model.TransactionDao;
import com.mvc.models.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewCustomerTransactionController")
public class ViewCustomerTransactionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        System.out.println(accountNumber);
        if (accountNumber == null || accountNumber.isEmpty()) {
            response.sendRedirect("transactionError.jsp?error=InvalidAccountNumber");
            return;
        }

        TransactionDao transactionDao = new TransactionDao();

        try {
            List<Transaction> transactions = transactionDao.getTransactionsByAccountNumber(accountNumber);
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("viewCustomerTransaction.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("transactionError.jsp?error=CouldNotRetrieveTransactions");
        }
    }
}
