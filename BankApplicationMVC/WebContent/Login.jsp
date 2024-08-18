<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Application Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            height: 100vh;
            margin: 0;
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
            background-size: cover;
            background-position: center;
            animation: backgroundChange 12s infinite;
        }

        @keyframes backgroundChange {
            0% { background-image: url('images/image1.jpg'); }
            25% { background-image: url('images/image2.jpg'); }
            50% { background-image: url('images/image3.jpg'); }
            75% { background-image: url('images/image4.jpg'); }
            100% { background-image: url('images/image1.jpg'); }
        }

        .login-container {
            background-color: rgba(255, 255, 255, 0.85);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.3);
            width: 400px;
            position: relative;
            z-index: 2;
        }

        .alert {
            background-color: #f44336;
            color: white;
            padding: 15px;
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            width: 80%;
            text-align: center;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            display: none;
            z-index: 3;
        }

        .alert .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }

        .alert .closebtn:hover {
            color: black;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group input[type="radio"] {
            width: auto;
        }

        .form-group button {
            width: 48%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-group .submit-btn {
            background-color: #4CAF50;
            color: white;
        }

        .form-group .cancel-btn {
            background-color: #f44336;
            color: white;
        }
    </style>
</head>
<body>
    <div class="alert" id="alertBox">
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
        <span id="alertMessage"></span>
    </div>
    <div class="login-container">
        <h2>Login</h2>
        <form action="LoginController" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label>Role:</label>
                <input type="radio" id="admin" name="role" value="admin" required>
                <label for="admin">Admin</label>
                <input type="radio" id="customer" name="role" value="customer">
                <label for="customer">Customer</label>
            </div>
            <div class="form-group">
                <button type="submit" class="submit-btn">Login</button>
                <button type="reset" class="cancel-btn">Cancel</button>
            </div>
        </form>
    </div>
    
    <script>
        // Check if there's an error query parameter in the URL
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has('error')) {
            const errorMessage = urlParams.get('error');
            document.getElementById('alertMessage').textContent = errorMessage === 'invalid' ? 'Invalid username or password.' : 'Invalid role selected.';
            document.getElementById('alertBox').style.display = 'block';
        }
    </script>
</body>
</html>
