<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Transaction</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
         
        .header {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }
        .header a {
            display: inline-block;
            padding: 8px 12px;
            font-size: 14px;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            background-color: #007bff;
            transition: background-color 0.3s ease;
            margin-left: 10px;
        }
        .header a.logout {
            background-color: #dc3545;
        }
        .header a:hover {
            background-color: #0056b3;
        }
        .header a.logout:hover {
            background-color: #c82333;
        }
        
        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 100%;
            max-width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="number"],
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
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .transfer-section {
            display: none;
        }
        .success-message {
            display: none;
            background-color: #007bff;
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
        .success-message .close-btn {
            position: absolute;
            top: 5px;
            right: 10px;
            cursor: pointer;
            font-weight: bold;
            color: #fff;
            background: none;
            border: none;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
     <script>
        function showSuccessMessage() {
            var successMessage = document.getElementById('successMessage');
            successMessage.style.display = 'block';

            // Automatically hide after 10-15 seconds
            setTimeout(function() {
                successMessage.style.display = 'none';
            }, 100000000); // 10 seconds
        }

        function closeSuccessMessage() {
            var successMessage = document.getElementById('successMessage');
            successMessage.style.display = 'none';
        }
    </script>
</head>
<body>
	<div class="wrapper">
	<div class="header">
            <a href="${pageContext.request.contextPath}/customerdashboard">Back to Dashboard</a>
            <a href="${pageContext.request.contextPath}/Logout.jsp" class="logout">Logout</a>
        </div>
    <div class="container">
    
        <h2>New Transaction</h2>
        <form action="ProcessTransactionController" method="post" onsubmit="showSuccessMessage()">
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required><br>

            <label for="transactionType">Transaction Type:</label>
            <select id="transactionType" name="transactionType" required>
                <option value="debit">Debit</option>
                <option value="credit">Credit</option>
                <option value="transfer">Transfer</option>
            </select><br>

            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" required><br>

            <div id="transferSection" class="transfer-section">
                <label for="recipientAccountNumber">Recipient Account Number:</label>
                <input type="text" id="recipientAccountNumber" name="recipientAccountNumber"><br>
            </div>

            <input type="submit" value="Submit">
        </form>
    </div>
   
   </div> 
    <div id="successMessage" class="success-message">
        <button class="close-btn" onclick="closeSuccessMessage()">X</button>
        Transaction created successfully!
    </div>
    

    <script>
        document.getElementById('transactionType').addEventListener('change', function() {
            var display = this.value === 'transfer' ? 'block' : 'none';
            document.getElementById('transferSection').style.display = display;
        });
    </script>
</body>
</html>
