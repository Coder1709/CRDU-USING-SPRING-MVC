<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
</head>
<body>
    <h1>Customer Information Form</h1>
    <form action="getDetails" method="post">
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId"><br><br>

        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName"><br><br>

        <label for="monthlyIncome">Monthly Income:</label>
        <input type="text" id="monthlyIncome" name="monthlyIncome"><br><br>

        <label for="profession">Profession:</label>
        <input type="text" id="profession" name="profession"><br><br>

        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation"><br><br>

        <label for="companyName">Company Name:</label>
        <input type="text" id="companyName" name="companyName"><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
