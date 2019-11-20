<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/10/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Detail Stock</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create New Stock</h1>
<p>
    <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/detailstocks"> Back to stocks list</a>
</p>
<form method="post">
    <fieldset>
        <legend> Detail Stock information</legend>
        <table>
            <tr>
                <td>Phone Amount:</td>
                <td><input type="text" name="phoneAmount" id="phoneAmount"></td>
            </tr>
            <tr>
                <td>Delete By:</td>
                <td><input type="text" name="deleteBy" id="deleteBy"></td>
            </tr>
            <tr>
                <td>Delete Date:</td>
                <td><input type="text" name="deleteDate" id="deleteDate"></td>
            </tr>
            <tr>
                <td>Modify By:</td>
                <td><input type="text" name="modifyBy" id="modifyBy"></td>
            </tr>
            <tr>
                <td>Modify Date:</td>
                <td><input type="text" name="modifyDate" id="modifyDate"></td>
            </tr>
            <tr>
                <td>Create By:</td>
                <td><input type="text" name="createBy" id="createBy"></td>
            </tr>
            <tr>
                <td>Create Date:</td>
                <td><input type="text" name="createDate" id="createDate"></td>
            </tr>
            <tr>
                <td>Submit</td>
                <td><input type="submit" value="Create Detail Stock"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
