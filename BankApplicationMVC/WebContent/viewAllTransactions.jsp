<%@ page import="java.util.List" %>
<%@ page import="com.mvc.models.Transaction" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Transactions</title>
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
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h2 {
            margin: 0;
        }
        .header .actions {
            display: flex;
            gap: 10px;
        }
        .header .actions form {
            margin: 0;
        }
        .header .actions button {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-back {
            background-color: #4CAF50;
            color: white;
        }
        .btn-logout {
            background-color: #f44336;
            color: white;
        }
        .btn-sort {
            padding: 8px;
            border-radius: 4px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h2>All Transactions</h2>
        <div class="actions">
            <!-- Sort Dropdown -->
            <!-- Sort Dropdown (Visible only if user is viewing their transactions) -->
<c:if test="${not empty param.accountNumber}">
    <form action="ViewAllTransactionsController" method="get">
        <input type="hidden" name="accountNumber" value="${param.accountNumber}"/>
        <select name="sortOrder" class="btn-sort" onchange="this.form.submit()">
            <option value="date asc" ${param.sortOrder == 'date asc' ? 'selected' : ''}>Sort by Date Asc</option>
            <option value="date desc" ${param.sortOrder == 'date desc' ? 'selected' : ''}>Sort by Date Desc</option>
        </select>
    </form>
</c:if>

            <!-- Back Button -->
            <form action="customerdashboard" method="get">
                <button type="submit" class="btn-back">Back to Dashboard</button>
            </form>
            <!-- Logout Button -->
            <form action="LogoutController" method="post">
                <button type="submit" class="btn-logout">Logout</button>
            </form>
        </div>
    </div>

    <table>
        <tr>
            <th>Sender Account Number</th>
            <th>Receiver Account Number</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <c:forEach var="transaction" items="${transactions}">
            <tr>
                <td><c:out value="${transaction.accountNumber}"/></td>
                <td><c:out value="${transaction.receiverAccountNumber != null ? transaction.receiverAccountNumber : 'N/A'}"/></td>
                <td><c:out value="${transaction.transactionType}"/></td>
                <td><c:out value="${transaction.amount}"/></td>
                <td><c:out value="${transaction.date}"/></td>
            </tr>
        </c:forEach>
        <c:if test="${empty transactions}">
            <tr>
                <td colspan="5">No transactions found.</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
