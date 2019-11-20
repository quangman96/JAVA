<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp" %>
<head>
    <title>Deleting customer</title>
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
<h1><span class="btn btn-info" role="textbox">Delete Store</span></h1>
<p>
    <a class="btn btn-primary" href="/stores" role="textbox">Back to Store</a>
</p>
<form method="post">
    <fieldset>
        <legend>store information</legend>
        <h3><span class="btn btn-danger">Are you sure?</span></h3>
        <table>
            <div class="input-group mb-3">
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Name Store</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="nameStore" name="nameStore" value="${requestScope["stores"].getNameStore()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Address Store</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="addressStore" name="addressStore"
                               value="${requestScope["stores"].getAddressStore()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">PhoneNumber: </span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="PhoneNumberStore" name="PhoneNumberStore" value="${requestScope["stores"].getPhoneNumberStore()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Delete By: </span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="deleteBy" name="deleteBy" >
                    </td>
                </tr>
            </div>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Delete Store </button>
                </td>
            </tr>
        </table>
    </fieldset>
</form></div>
</body>
</html>
