<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
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
            flex-direction: column; /* Center content vertically */
        }
        .wrapper {
            width: 100%;
            max-width: 600px;
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            position: relative;
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
            max-width: 400px;
            margin: 0 auto;
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
        input[type="password"] {
            width: 100%;
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
        .alert {
            color: red;
            text-align: center;
            margin-bottom: 20px; /* Adjust spacing between alert and form */
            padding: 10px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
        }
        .success {
            color: green;
            text-align: center;
            margin-top: 20px;
            padding: 10px;
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="alert" style="display: ${not empty param.error ? 'block' : 'none'};">
        <c:if test="${not empty param.error}">
            ${param.error}
        </c:if>
    </div>

    <div class="wrapper">
        <div class="header">
            <a href="${pageContext.request.contextPath}/customerdashboard">Back to Dashboard</a>
            <a href="${pageContext.request.contextPath}/Logout.jsp" class="logout">Logout</a>
        </div>
        <div class="container">
            <h2>Edit Profile</h2>
            <form action="${pageContext.request.contextPath}/EditProfileController" method="post">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>

                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" required>

                <label for="password">New Password:</label>
                <input type="password" id="password" name="password" required>

                <input type="submit" value="Update Profile">
            </form>
        </div>
    </div>

    <!-- Display success message if present -->
    <c:if test="${not empty param.message}">
        <p class="success">${param.message}</p>
    </c:if>
</body>
</html>
