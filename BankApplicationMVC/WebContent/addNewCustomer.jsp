<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #007bff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 10px;
            z-index: 1000;
        }
        .header h2 {
            margin: 0;
            flex-grow: 1;
            text-align: center;
            color: #fff;
        }
        .header a {
            position: absolute;
            right: 20px;
            background-color: #dc3545;
            color: #fff;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .container {
            margin-top: 80px;
            text-align: center;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            width: 100%;
        }
        .error-message {
            display: none;
            background-color: #dc3545;
            color: #fff;
            border-radius: 4px;
            padding: 10px;
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            z-index: 1000;
            min-width: 200px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .error-message .close-btn {
            position: absolute;
            top: 5px;
            right: 10px;
            cursor: pointer;
            font-weight: bold;
            color: #fff;
            background: none;
            border: none;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="password"],
        select {
            width: calc(100% - 22px);
            padding: 12px;
            margin-bottom: 16px;
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
    </style>
    <script>
        function showErrorMessage(message) {
            var errorMessage = document.getElementById('errorMessage');
            errorMessage.innerText = message;
            errorMessage.style.display = 'block';

            // Automatically hide after 5 seconds
            setTimeout(function() {
                errorMessage.style.display = 'none';
            }, 5000);
        }

        function closeErrorMessage() {
            var errorMessage = document.getElementById('errorMessage');
            errorMessage.style.display = 'none';
        }
    </script>
</head>
<body>
    <div class="header">
        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
        <a href="Logout.jsp">Logout</a>
    </div>

    <!-- Error Message Popup -->
    <div id="errorMessage" class="error-message">
        <button class="close-btn" onclick="closeErrorMessage()">X</button>
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </div>

    <div class="container">
        <h3>Add New Customer</h3>
        <form action="UserController" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username" required><br>

            <label for="password">Password:</label>
            <input type="password" name="password" required><br>

            <label for="role">Role:</label>
            <select name="role" required>
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select><br>

            <input type="submit" value="Add Customer">
        </form>
        <a href="adminDashboard.jsp" class="back-link">Back to Dashboard</a>
    </div>

    <script>
        <% if (request.getAttribute("errorMessage") != null) { %>
            showErrorMessage('<%= request.getAttribute("errorMessage") %>');
        <% } %>
    </script>
</body>
</html>
