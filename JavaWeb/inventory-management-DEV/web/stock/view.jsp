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
    <title>View Stock</title>
</head>
<body>
<h1>Stock Details</h1>
<p>
    <a href="/stocks">Back to Stock list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["stock"].getName()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["stock"].getAddress()}</td>
    </tr>
    <tr>
        <td>PhoneNumber: </td>
        <td>${requestScope["stock"].getPhoneNumber()}</td>
    </tr>
    <tr>
        <td>CreateBy: </td>
        <td>${requestScope["stock"].getCreateBy()}</td>
    </tr>
</table>
</body>
</html>
