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
    <title>Edit Staff</title>
    <style>
        .message {
            color: yellow;
        }
    </style>
</head>
<body>
<h1><span class="btn btn-info">Edit Staff</span></h1>
<div class="alert alert-danger" role="alert">

<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
</div>
<p>
    <a class="btn btn-primary" href="/staffs" role="button">Back to Staff</a>
</p>
<form method="post">
    <fieldset>
        <legend>Staff information</legend>
        <table>
            <div class="input-group mb-3">

            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Name Staff</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="name" name="name" value="${requestScope["staffInformation"].getName()}">
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Age</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="age" name="age" value="${requestScope["staffInformation"].getAge()}">
                </td>
<%--                <td>Age: </td>--%>
<%--                <td><input type ="text" name = "age" id ="age" value="${requestScope["staffInformation"].getAge()}"></td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Pass</span>
                    </div>
                    <input type="password" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="pass" name="pass" value="${requestScope["staffInformation"].getPass()}">
                </td>
<%--                <td>Pass: </td>--%>
<%--                <td><input type ="password" name = "pass" id ="pass" value="${requestScope["staffInformation"].getPass()}"></td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Address</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="address" name="address" value="${requestScope["staffInformation"].getAddress()}">
                </td>
<%--                <td>Address: </td>--%>
<%--                <td><input type="text" name="address" id="address" value="${requestScope["staffInformation"].getAddress()}"></td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Phone Number:</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="phoneNumber" name="phoneNumber" value="${requestScope["staffInformation"].getPhoneNumber()}">
                </td>
<%--                <td>PhoneNumber </td>--%>
<%--                <td><input type="text" name="phoneNumber" id="phoneNumber" value="${requestScope["staffInformation"].getPhoneNumber()}"></td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Gender: </span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="gender" name="gender" value="${requestScope["staffInformation"].getGender()}">
                </td>
<%--                <td>Gender: </td>--%>
<%--                <td><input type ="text" name = "gender" id ="gender"value="${requestScope["staffInformation"].getGender()}"></td>--%>
            </tr>
            <tr>
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Modify By: </span>
                    </div>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-default"
                           id="modifyBy" name="modifyBy" value="${requestScope["staffInformation"].getModifyBy()}">
                </td>
<%--                <td>Modify By</td>--%>
<%--                <td> <input type="text" name = "modifyBy" id = "modifyBy"value="${requestScope["staffInformation"].getModifyBy()}"></td>--%>
            </tr>
            </div>
            <tr>
                <td>
                <button type="submit" class="btn btn-success">Update Staff</button>
                </td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
