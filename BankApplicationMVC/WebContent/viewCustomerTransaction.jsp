<%@ page import="java.util.List" %>
<%@ page import="com.mvc.models.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Customer Transactions</h2>
    <table>
        <tr>
            <th>Account Number</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Balance</th>
            <th>Receiver Account Number</th>
            <th>Date</th>
        </tr>
        <%
            // Retrieve the list of transactions from the request attribute
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
            // Check if the list is not null and has transactions
            if (transactions != null && !transactions.isEmpty()) {
                // Iterate through the list of transactions and display each transaction in a table row
                for (Transaction transaction : transactions) {
        %>
        <tr>
            <td><%= transaction.getAccountNumber() %></td>
            <td><%= transaction.getTransactionType() %></td>
            <td><%= transaction.getAmount() %></td>
            <td><%= transaction.getBalance() %></td>
            <td><%= transaction.getReceiverAccountNumber() != null ? transaction.getReceiverAccountNumber() : "N/A" %></td>
            <td><%= transaction.getDate() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No transactions found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
