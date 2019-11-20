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
    <title>Brands List</title>
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
    <h1>Brands List</h1>
    <button type="button" class="btn btn-primary">
        <a href="/brands?action=create">Create New Brand</a>
    </button>
    <p></p>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <td>Name</td>
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
        <c:forEach items='${requestScope["brandList"]}' var="brand">
            <tr>
                <td>
                    <a href="/phones?action=viewList&id=${brand.getIdBrand()}">${brand.getName()}</a>
                </td>
                <td>${brand.getCreateBy()}</td>
                <td>${brand.getCreateDate()}</td>
                <td>${brand.getModifyBy()}</td>
                <td>${brand.getModifyDate()}</td>
<%--                <td>${brand.getDeleteBy()}</td>--%>
<%--                <td>${brand.getDeleteDate()}</td>--%>
                <td>
                    <button type="button" class="btn btn-info">
                        <a href="/brands?action=edit&id=${brand.getIdBrand()}">edit</a>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger">
                        <a href="/brands?action=delete&id=${brand.getIdBrand()}">delete</a>
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
