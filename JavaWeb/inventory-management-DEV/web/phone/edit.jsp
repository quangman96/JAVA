<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit phone</title>
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
        <h1>Edit Phone</h1>
    </div>
    <div class="row">
        <c:if test='${requestScope["message"] != null}'>
                    <span class="message">
                        <div class="alert alert-success">
                            <strong>Success!</strong>${requestScope["message"]}
                        </div>
                    </span>
        </c:if>
    </div>
    <button type="button" class="btn btn-secondary">
        <a href="/phones">Back to phone list</a>
    </button>
    <form method="post">
        <fieldset>
            <legend>Brand information</legend>

                    <div class="form-row">
                        <label>Name:</label>
                        <input type="text" class="form-control is-invalid" id="name" name="name"
                               value="${requestScope["phone"].getName()}" required>
                        <div class="invalid-feedback">
                            Please provide a valid Name Phone.
                        </div>
                    </div>
                    <div class="form-row">
                        <label>Amount:</label>
                        <input type="text" class="form-control is-invalid" id="amount" name="amount"
                               value="${requestScope["phone"].getAmount()}" required>
                        <div class="invalid-feedback">
                            Please provide a valid Amount Phone.
                        </div>
                    </div>
                    <div class="form-row">
                        <label>Information:</label>
                        <textarea  rows="10" cols="30" name="information" id="information" class="form-control"></textarea>

                    </div>

                    <div class="form-row">
                        <label>Image:</label>
                        <input type="text" class="form-control is-invalid" id="image" name="image"
                               value="${requestScope["phone"].getImage()}" required>
                        <div class="invalid-feedback">
                            Please provide a valid Phone Image.
                        </div>
                    </div>

                    <div class="form-row">
                        <label>Modify By: </label>
                        <input type="text" class="form-control is-invalid" id="modifyBy" name="modifyBy"
                               value="${requestScope["phone"].getModifyBy()}" required>
                        <div class="invalid-feedback">
                            Please provide a valid  Name modify By.
                        </div>
                    </div>

                    <button class="btn btn-primary" type="submit">Edit phone</button>

        </fieldset>
    </form>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <p>Footer</p>
</body>
</html>
