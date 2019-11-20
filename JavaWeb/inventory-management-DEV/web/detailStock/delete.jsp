<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Stock</title>
</head>
<body>
<h1>Delete Stock</h1>
<p>
    <a href="/detailstocks">Back to stock list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Detail Stock information</legend>
        <table>
            <tr>
                <td>Phone Number:</td>
                <td>${requestScope["detailStock"].getPhoneNumber()}</td>
            </tr>
            <tr>Stock
                <td>DeleteBy:</td>
                <td>${requestScope["detailStock"].getDeleteBy()}</td>
            </tr>
            <tr>
                <td>DeleteDate:</td>
                <td>${requestScope["detailStock"].getDeleteDate()}</td>
            </tr>
            <tr>
                <td>ModifyBy:</td>
                <td>${requestScope["detailStock"].getModifyBy()}</td>
            </tr>
            <tr>
                <td>ModifyDate:</td>
                <td>${requestScope["detailStock"].getModifyDate()}</td>
            </tr>
            <tr>
                <td>CreateBy:</td>
                <td>${requestScope["detailStock"].getCreateBy()}</td>
            </tr>
            <tr>
                <td>CreateDate:</td>
                <td>${requestScope["detailStock"].getCreateDate()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Detail Stock"></td>
                <td><a href="/detailstocks">Back to stocks list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
