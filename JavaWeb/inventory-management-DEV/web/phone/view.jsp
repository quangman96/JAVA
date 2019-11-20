<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>phone</title>
</head>
<body>
<h1>phone details</h1>
<p>
    <a href="/phones">Back to phone list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["phone"].getName()}</td>
    </tr>
    <tr>
        <td>Amount: </td>
        <td>${requestScope["phone"].getAmount()}</td>
    </tr>
    <tr>
        <td>Brand name: </td>
        <td>${requestScope["phone"].getBrandName()}</td>
    </tr>
    <tr>
        <td>Information: </td>
        <td>${requestScope["phone"].getInformation()}</td>
    </tr>
    <tr>
        <td>Image: </td>
        <td>${requestScope["phone"].getImage()}</td>
    </tr>
    <tr>
        <td>Create By:</td>
        <td>${requestScope["phone"].getCreateBy()}</td>
    </tr>
</table>

</body>
</html>
