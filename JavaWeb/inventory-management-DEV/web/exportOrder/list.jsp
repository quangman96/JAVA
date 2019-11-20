<%--
  Created by IntelliJ IDEA.
  User: quangman
  Date: 11/11/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ExportOrder List</title>
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
        <p>ExportOrder</p>
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
    <h1>Export Order List</h1>
    <button type="button" class="btn btn-outline-primary">
    <p>
        <a href="/exportOrder?action=create">Create new Export Order</a>
    </p>
        </button>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">NameStaff</th>
                    <th scope="col">NameStock</th>
                    <th scope="col">NameStore</th>
                    <th scope="col">CreateBy</th>
                    <th scope="col">CreateDate</th>
                    <th scope="col">ModifyBy</th>
                    <th scope="col">ModifyDate</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items='${requestScope["exportOrders"]}' var="export">
                    <tr>
                        <td>${export.getIdExportOrder()}</td>
                        <td><a href="/detailExportOrders?action=view&idExportOrder=${export.getIdExportOrder()}">${export.getName()}</a></td>
                        <td>${export.getNameStaff()}</td>
                        <td>${export.getNameStock()}</td>
                        <td>${export.getNameStore()}</td>
                        <td>${export.getCreateBy()}</td>
                        <td>${export.getCreateDate()}</td>
                        <td>${export.getModifyBy()}</td>
                        <td>${export.getModifyDate()}</td>
                        <td>
                            <button type="button" class="btn btn-outline-primary">
                            <a href="/exportOrder?action=edit&id=${export.getIdExportOrder()}">edit</a>
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-outline-primary">
                            <a href="/exportOrder?action=delete&id=${export.getIdExportOrder()}">delete</a>
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