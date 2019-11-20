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
    <title>Deleting employer</title>
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
<h1>Delete staff</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/staffs">Back to staff list</a>
</p>

<form method="post">
    <fieldset>
        <legend>Staff information</legend>
        <h3><span class="btn btn-danger">Are you sure?</span></h3>

        <table>
            <div class="input-group mb-3">
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Name Staff</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           value="${requestScope["staffInformation"].getName()}">
                </td>
<%--                <td>Name: </td>--%>
<%--                <td>${requestScope["staffInformation"].getName()}</td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Age</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           value="${requestScope["staffInformation"].getAge()}">
                </td>
<%--                <td>Age: </td>--%>
<%--                <td>${requestScope["staffInformation"].getAge()}</td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Address :</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           value="${requestScope["staffInformation"].getAddress()}">
                </td>
<%--                <td>Address: </td>--%>
<%--                <td>${requestScope["staffInformation"].getAddress()}</td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Address :</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           value="${requestScope["staffInformation"].getPhoneNumber()}">
                </td>
<%--                <td>Phone Number: </td>--%>
<%--                <td>${requestScope["staffInformation"].getPhoneNumber()}</td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Gender:</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           value="${requestScope["staffInformation"].getGender()}">
                </td>
<%--                <td>Gender: </td>--%>
<%--                <td>${requestScope["staffInformation"].getGender()}</td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Delete By:</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                            name="deleteBy" id="deleteBy">
                </td>
<%--                <td>Delete By: </td>--%>
<%--                <td> <input type="text" name = "deleteBy" id = "deleteBy"/> </td>--%>
            </tr>

            <tr>

            </tr>
            </div>
        </table>
    </fieldset>
    <button type="submit" class="btn btn-success">Delete Staff </button>
    <td><a href="/staffs">Back to staff list</a></td>
</form></div>
</body>


</html>

