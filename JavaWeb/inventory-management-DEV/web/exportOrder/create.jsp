<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quangman
  Date: 11/11/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new ExportOrder</title>
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
    <p>Create ExportOrder</p>
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
                <a class="nav-link" href="/exportOrder">ExportOrder</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/importOrders">import Orders</a>
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
    <div class="row">
        <h1>Create new exportOrder</h1>
    </div>
    <c:if test='${requestScope["message"] != null}'>
                <span class="message">
                    <div class="alert alert-success">
                        <strong>Success!</strong>${requestScope["message"]}
                    </div>
                </span>
    </c:if>
    <button type="button" class="btn btn-secondary">
        <a href="/exportOrder">Back to ExportOrder list</a>
    </button>
    <form method="post">
        <fieldset>
            <legend>ExportOrder information</legend>
            <div class="form-row">
                <label>Name:</label>
                <input type="text" class="form-control is-invalid" id="name" name="name"
                       placeholder="Enter name ExportOrder" required>
                <div class="invalid-feedback">
                    Please provide a valid ExportOrder.
                </div>
            </div>
            <div class="form-row">
                <label>Staff:</label>
                <select id="idStaff" name="idStaff" class="custom-select">
                    <c:forEach items='${requestScope["staffList"]}' var="staff">
                        <option value="${staff.getIdStaff()}">${staff.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>Store:</label>
                <select id="idStore" name="idStore" class="custom-select">
                    <c:forEach items='${requestScope["storeList"]}' var="store">
                        <option value="${store.getIdStore()}">${store.getNameStore()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>Stock:</label>
                <select id="idStock" name="idStock" class="custom-select">
                    <c:forEach items='${requestScope["storeList"]}' var="store">
                        <option value="${store.getIdStock()}">${store.getNameStock()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>CreateBy:</label>
                <input type="text" class="form-control is-invalid" id="createBy" name="createBy"
                       placeholder="Enter createBy" required>
                <div class="invalid-feedback">
                    Please provide a valid creater.
                </div>
            </div>
            <div class="form-row">
                <label>Phone:</label>
                <select id="idPhone2" name="idPhone2" class="custom-select">
                    <c:forEach items='${requestScope["phoneList"]}' var="phone1">
                        <option value="${phone1.getIdPhone()}">${phone1.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>Amount:</label>
                <input type="text" class="form-control is-invalid" id="AmountPhone" name="AmountPhone"
                       placeholder="Enter Amount Phone" required>
                <div class="invalid-feedback">
                    Please provide a valid Amount Phone.
                </div>
            </div>
        </fieldset>
        <button class="btn btn-primary" type="submit">Create exportOrder</button>
    </form>
</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>
</body>
</html>