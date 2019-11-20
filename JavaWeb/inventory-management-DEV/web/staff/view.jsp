<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp" %>
<head>
    <title>View Staff</title>
</head>
<body>
<h1><span class="btn btn-info">Staff details</span></h1>
<p>
    <a class="btn btn-primary" href="/staffs" role="button">Back to Staff</a>
</p>
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
        </tr>
        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Gender: </span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getGender()}">
            </td>
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
        </tr>

        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Address</span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getAddress()}">
            </td>
        </tr>
        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Phone Number:</span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getPhoneNumber()}">
            </td>
        </tr>
        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Modify By: </span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getModifyBy()}">
            </td>
        </tr>
        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Modify date : </span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getModifyDate()}">
            </td>

        </tr>
        <tr>
            <td>
                <div class="input-group-prepend">
                    <span class="input-group-text">Create By : </span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-default"
                       value="${requestScope["staffInformation"].getCreateBy()}">
            </td>
        </tr>
        <tr>
            <div class="input-group-prepend">
                <span class="input-group-text">Create date : </span>
            </div>
            <input type="text" class="form-control" aria-label="Sizing example input"
                   aria-describedby="inputGroup-sizing-default"
                   value="${requestScope["staffInformation"].getCreateDate()}">
        </tr>
    </div>
</table>
</body>
</html>