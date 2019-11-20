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
    <title>Stocks List</title>
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
    <h1>Stocks</h1>
    <button type="button" class="btn btn-outline-primary">
        <a href="/stocks?action=create">Create New Stock</a>
    </button>
    <p></p>

    <table class="table table-hover">
        <thead class="thead">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Create By</th>
            <th scope="col">Create Date</th>
            <th scope="col">Modify By</th>
            <th scope="col">Modify Date</th>
<%--            <th scope="col">Delete By</th>--%>
<%--            <th scope="col">Delete Date</th>--%>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["stockList"]}' var="stock">
            <tr>
                <td>
                    <a href="/detailstocks?action=view&idStock=${stock.getIdStock()}">${stock.getName()}</a>
                </td>
                <td>${stock.getAddress()}</td>
                <td>${stock.getPhoneNumber()}</td>
                <td>${stock.getCreateBy()}</td>
                <td>${stock.getCreateDate()}</td>
                <td>${stock.getModifyBy()}</td>
                <td>${stock.getModifyDate()}</td>
<%--                <td>${stock.getDeleteBy()}</td>--%>
<%--                <td>${stock.getDeleteDate()}</td>--%>
                <td>
                    <button type="button" class="btn btn-outline-primary">
                        <a href="/stocks?action=edit&id=${stock.getIdStock()}">Edit</a>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-primary">
                        <a href="/stocks?action=delete&id=${stock.getIdStock()}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>
</body>
</html>
