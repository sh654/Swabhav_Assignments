<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mvc.models.CustomerAccountInfo" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Customer and Account Information</title>
    <style>
    	.back-btn {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h2>Customer and Account Information</h2>

        <!-- Search and Filter Form -->
        <form action="ViewCustomerController" method="get" class="mb-3">
            <div class="row mb-3">
                <div class="col-md-4">
                    <input type="text" class="form-control" name="search" placeholder="Search by account number" value="${param.search}">
                </div>
                <div class="col-md-4">
                    <select class="form-select" name="filter_by">
                        <option value="">Filter by</option>
                        <option value="balance" ${param.filter_by == 'balance' ? 'selected' : ''}>Balance</option>
                        <option value="first_name" ${param.filter_by == 'first_name' ? 'selected' : ''}>First Name</option>
                        <option value="last_name" ${param.filter_by == 'last_name' ? 'selected' : ''}>Last Name</option>
                        <option value="customer_id" ${param.filter_by == 'customer_id' ? 'selected' : ''}>Customer ID</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <select class="form-select" name="sort_order">
                        <option value="">Sort Order</option>
                        <option value="customer_id ASC" ${param.sort_order == 'customer_id ASC' ? 'selected' : ''}>Customer ID Ascending</option>
                        <option value="customer_id DESC" ${param.sort_order == 'customer_id DESC' ? 'selected' : ''}>Customer ID Descending</option>
                        <option value="balance ASC" ${param.sort_order == 'balance ASC' ? 'selected' : ''}>Balance Ascending</option>
                        <option value="balance DESC" ${param.sort_order == 'balance DESC' ? 'selected' : ''}>Balance Descending</option>
                    </select>
                </div>
            </div>
            
            <button type="submit" class="btn btn-primary">Apply</button>
        </form>
	<a href="${pageContext.request.contextPath}/adminDashboard.jsp">
                <button class="back-btn">Go Back to Admin Dashboard</button>
    </a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Account Number</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty customerAccountList}">
                        <c:forEach var="info" items="${customerAccountList}">
                            <tr>
                                <td>${info.customerId}</td>
                                <td>${info.firstName}</td>
                                <td>${info.lastName}</td>
                                <td>${info.accountNumber}</td>
                                <td>${info.balance}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5">No data available</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
