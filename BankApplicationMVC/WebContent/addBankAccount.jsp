<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Bank Account & Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #007bff;
            color: #fff;
            padding: 15px 30px;
            margin-bottom: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .header h2 {
            margin: 0;
            flex-grow: 1;
            text-align: center;
            color: #fff;
        }
        .header a {
            color: #fff;
            text-decoration: none;
            background-color: #dc3545;
            padding: 10px 15px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .header a:hover {
            background-color: #c82333;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 500px;
            margin: 20px auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="number"],
        input[type="email"],
        input[type="password"],
        select {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .alert {
            display: none;
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            background-color: #f44336;
            color: white;
            text-align: center;
            padding: 15px;
            z-index: 1000;
            border-radius: 4px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .alert.show {
            display: block;
        }
        .alert .close {
            position: absolute;
            right: 20px;
            top: 50%;
            transform: translateY(-50%);
            background: none;
            border: none;
            color: white;
            font-size: 20px;
            cursor: pointer;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="header">
    <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
    <a href="Logout.jsp">Logout</a>
</div>

<h2>Add Customer</h2>
<form action="CustomerAccountController" method="post">
    <input type="hidden" name="form_type" value="customer_form" />

    <label for="user_id">User ID:</label>
    <input type="number" id="user_id" name="user_id" required />

    <label for="first_name">First Name:</label>
    <input type="text" id="first_name" name="first_name" required />

    <label for="last_name">Last Name:</label>
    <input type="text" id="last_name" name="last_name" required />

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required />

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required />

    <input type="submit" value="Add Customer" />
</form>

<h2>Add Bank Account</h2>
<form action="CustomerAccountController" method="post">
    <input type="hidden" name="form_type" value="account_form" />

    <label for="customer_id">Customer ID:</label>
    <input type="number" id="customer_id" name="customer_id" required />

    <label for="account_type">Account Type:</label>
    <select id="account_type" name="account_type" required>
        <option value="savings">Savings</option>
        <option value="current">Current</option>
    </select>

    <label for="balance">Initial Balance:</label>
    <input type="number" id="balance" name="balance" step="0.01" required />

    <input type="submit" value="Create Account" />
</form>

<c:if test="${not empty error}">
    <div class="alert show">
        ${error}
        <button class="close">&times;</button>
    </div>
</c:if>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var alertBox = document.querySelector('.alert.show');
        if (alertBox) {
            var closeButton = alertBox.querySelector('.close');
            closeButton.onclick = function() {
                alertBox.style.display = 'none';
            };
        }
    });
</script>

</body>
</html>
