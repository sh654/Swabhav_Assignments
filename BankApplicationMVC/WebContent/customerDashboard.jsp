<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #fff;
            padding: 10px 20px;
            border-bottom: 1px solid #ddd;
            margin-bottom: 20px;
        }
        .header h2 {
            margin: 0;
            color: #333;
            text-align: center;
            flex-grow: 1;
        }
        .header a.btn {
            margin-left: auto;
            margin-right: 10px;
        }
        .actions-row {
            display: flex;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }
        .actions-row .form-group,
        .actions-row .nav-item {
            margin-right: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="header">
            <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
            <a href="Logout.jsp" class="btn btn-danger">Logout</a>
        </div>

        <div class="actions-row mt-5">
            <!-- Dropdown Form to Select Account Number -->
            <form action="ViewAllTransactionsController" method="get" class="form-inline d-flex align-items-center">
                <div class="form-group">
                    <label for="accountNumber" class="form-label">Select Account:</label>
                    <select name="accountNumber" id="accountNumber" class="form-select">
                        <c:forEach var="account" items="${accountsid}">
                            <option value="${account}">${account}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- View Transactions Button -->
                <button type="submit" class="btn btn-primary mx-3">View Transactions</button>
            </form>

            <!-- New Transaction Link -->
            <a class="nav-link active" aria-current="page" href="newTransaction.jsp"><button type="submit" class="btn btn-primary mx-3">New Transaction</button></a>

            <!-- Edit Profile Link -->
            <a class="nav-link active" aria-current="page" href="editProfile.jsp"><button type="submit" class="btn btn-primary mx-3">Edit Profile</button></a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
