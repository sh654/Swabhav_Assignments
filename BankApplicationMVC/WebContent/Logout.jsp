<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        .alert-box {
            display: none;
            position: fixed;
            top: 20%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            border: 2px solid red;
            border-radius: 10px;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }
        .alert-box h4 {
            margin: 0;
            color: red;
        }
        .loader {
            position: absolute;
            top: 10px;
            left: 50%;
            transform: translateX(-50%);
            border: 4px solid rgba(0, 0, 0, 0.1);
            border-radius: 50%;
            border-top: 4px solid red;
            width: 40px;
            height: 40px;
            animation: spin 1s linear infinite;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>
<body>
    <div class="loader"></div>
    <div class="alert-box" id="alertBox">
        <h4>You have been logged out successfully!</h4>
    </div>

    <script>
        function showAlertAndRedirect() {
            var alertBox = document.getElementById('alertBox');
            alertBox.style.display = 'block';
            setTimeout(function() {
                alertBox.style.display = 'none';
                window.location.href = 'Login.jsp';
            }, 10000); // 10 seconds
        }

        window.onload = function() {
            showAlertAndRedirect();
        }
    </script>
</body>
</html>
