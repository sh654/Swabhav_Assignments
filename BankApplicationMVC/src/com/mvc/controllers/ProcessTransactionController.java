package com.mvc.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.model.AccountOperationsDao;

@WebServlet("/ProcessTransactionController")
public class ProcessTransactionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String transactionType = request.getParameter("transactionType");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        String receiverAccountNumber = null;

        if ("transfer".equals(transactionType)) {
            receiverAccountNumber = request.getParameter("recipientAccountNumber");
        }

        AccountOperationsDao accountOperationsDao = new AccountOperationsDao();

        try {
            switch (transactionType) {
                case "debit":
                case "credit":
                    accountOperationsDao.updateBalance(accountNumber, amount, transactionType.equals("debit") ? "Debit" : "Credit", null);
                    break;
                case "transfer":
                    if (receiverAccountNumber == null || receiverAccountNumber.isEmpty()) {
                        response.sendRedirect("transactionError.jsp?error=ReceiverAccountNumberMissing");
                        return;
                    }
                    accountOperationsDao.transferAmount(accountNumber, receiverAccountNumber, amount);
                    break;
                default:
                    response.sendRedirect("transactionError.jsp?error=InvalidTransactionType");
                    return;
            }
            response.sendRedirect("successTransaction.jsp");
        } catch (IllegalArgumentException e) {
            // Handle validation exceptions
            response.sendRedirect("transactionError.jsp?error=" + e.getMessage().replace(" ", "%20"));
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
            response.sendRedirect("transactionError.jsp?error=TransactionFailed");
        }
    }
}
