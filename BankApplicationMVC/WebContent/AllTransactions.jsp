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
        .header-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        .header-container h2 {
            margin: 0;
        }
        .header-actions {
            display: flex;
            align-items: center;
        }
        .header-actions form,
        .header-actions a {
            margin-left: 10px;
        }
        .header-actions select {
            padding: 5px;
            font-size: 16px;
        }
        .header-actions button {
            padding: 5px 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .header-actions .logout-btn {
            background-color: #f44336;
            color: white;
        }
        .header-actions .back-btn {
            background-color: #4CAF50;
            color: white;
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
    <div class="header-container">
        <h2>All Transactions</h2>
        <div class="header-actions">
            <!-- Sorting Form -->
            <form method="get" action="${pageContext.request.contextPath}/adminviewalltransactions">
                <label for="sortOrder" style="display: none;">Sort by Date:</label>
                <select id="sortOrder" name="sortOrder" onchange="this.form.submit()">
                    <option value="asc" ${param.sortOrder == 'asc' ? 'selected' : ''}>Ascending</option>
                    <option value="desc" ${param.sortOrder == 'desc' ? 'selected' : ''}>Descending</option>
                </select>
            </form>
            <!-- Go Back Button -->
            
            <!-- Logout Button -->
            <a href="${pageContext.request.contextPath}/Logout.jsp">
                <button class="logout-btn">Logout</button>
            </a>
            
            <a href="${pageContext.request.contextPath}/adminDashboard.jsp">
                <button class="back-btn">Go Back to Admin Dashboard</button>
            </a>
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
