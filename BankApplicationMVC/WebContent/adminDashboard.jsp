<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .nav-box {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .nav-box h4 {
            margin: 0;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="header">
            <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
            <a href="Logout.jsp" class="btn btn-danger">Logout</a>
        </div>
        <div class="row mt-4">
            <div class="col-md-3">
                <div class="nav-box">
                    <a href="addNewCustomer.jsp">
                        <h4>Add New Customer</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3">
                <div class="nav-box">
                    <a href="addBankAccount.jsp">
                        <h4>Add Bank Account</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3">
                <div class="nav-box">
                    <a href="ViewCustomerController?action=viewCustomers">
                        <h4>View Customers</h4>
                    </a>
                </div>
            </div>
            <div class="col-md-3">
                <div class="nav-box">
                    <a href="adminviewalltransactions">
                        <h4>View Transactions</h4>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
