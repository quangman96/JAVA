<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Stock</title>
</head>
<body>
    <div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Mobile Warehouse Management </h1>
    <p>Delete Brand</p>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="http://localhost:8080/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/phones">Phones</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/brands">Brands</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/exportOrder">Export Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/importOrders">Import Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stores">Stores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stocks">Stocks</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
<h1>Delete Stock</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/stocks">Back to stock list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Stock information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["stock"].getName()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope["stock"].getAddress()}</td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td>${requestScope["stock"].getPhoneNumber()}</td>
            </tr>
            <tr>
                <td>Delete By:</td>
                <td><input type="text" name="deleteBy" id="deleteBy" value="${requestScope["stock"].getDeleteBy()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Stock"></td>
                <td><a href="/stocks">Back to stocks list</a></td>
            </tr>
        </table>
    </fieldset>
</form></div>
</body>
</html>
