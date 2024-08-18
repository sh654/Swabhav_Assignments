<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transaction Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .error-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            text-align: center;
        }
        .error-title {
            font-size: 24px;
            color: #e74c3c;
            margin-bottom: 20px;
        }
        .error-message {
            font-size: 16px;
            color: #333;
        }
        .home-link {
            margin-top: 20px;
            display: inline-block;
            font-size: 16px;
            color: #3498db;
            text-decoration: none;
            border: 1px solid #3498db;
            padding: 8px 16px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .home-link:hover {
            background-color: #3498db;
            color: white;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-title">Transaction Failed</div>
        <div class="error-message">
            <p><%= request.getParameter("error") != null ? request.getParameter("error") : "An unknown error occurred." %></p>
        </div>
        <a class="home-link" href="newTransaction.jsp">Back to Transactions</a>
    </div>
</body>
</html>
