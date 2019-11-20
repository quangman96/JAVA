<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phones list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/CSS/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Mobile Warehouse Management </h1>
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
                <a class="nav-link" href="/staffs">Staffs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stores">Stores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stocks">Stocks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/importOrders">Import Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/exportOrder">Export Orders</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>Phones</h1>
    <form method="get" action="/phones?action=search">
        <input type="text" id="action" name="action" value="search" hidden>
        <input type="text" id="inputValue" name="inputValue">
        <input type="submit" value="search">
    </form>
    <button type="button" class="btn btn-outline-primary">
        <a href="/phones?action=create">Create New Phone</a>
    </button>
    <p></p>

    <table class="table table-hover">
        <thead class="thead">
        <tr>
            <td>Name</td>
            <td>Amount</td>
<%--            <td>Information</td>--%>
<%--            <td>Image</td>--%>
            <td>BrandName</td>
            <td>Create By</td>
            <td>Create Date</td>
            <td>Modify By</td>
            <td>Modify Date</td>
<%--            <td>Delete By</td>--%>
<%--            <td>Delete Date</td>--%>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["phonesList"]}' var="phone">
        <tr>
            <td><a href="/phones?action=view&id=${phone.getIdPhone()}">${phone.getName()}</a></td>
            <td>${phone.getAmount()}</td>
<%--            <td>${phone.getInformation()}</td>--%>
<%--            <td>${phone.getImage()}</td>--%>
            <td>${phone.getBrandName()}</td>
            <td>${phone.getCreateBy()}</td>
            <td>${phone.getCreateDate()}</td>
            <td>${phone.getModifyBy()}</td>
            <td>${phone.getModifyDate()}</td>
<%--            <td>${phone.getDeleteBy()}</td>--%>
<%--            <td>${phone.getDeleteDate()}</td>--%>
            <td>
                <button type="button" class="btn btn-outline-primary">
                    <a href="/phones?action=edit&id=${phone.getIdPhone()}">Edit</a>
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-outline-primary">
                    <a href="/phones?action=delete&id=${phone.getIdPhone()}">Delete</a>
                </button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
