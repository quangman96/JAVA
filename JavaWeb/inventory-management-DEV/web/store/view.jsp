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
    <title>View Store</title>
</head>
<body>
<h1>Store details</h1>
<p>
    <a href="/stores">Back to store list</a>
</p>
<table>
    <tr>
        <td>Name Store: </td>
        <td>${requestScope["stores"].getNameStore()}</td>
    </tr>

    <tr>
        <td>Address: </td>
        <td>${requestScope["stores"].getAddressStore()}</td>
    </tr>
    <tr>
        <td>PhoneNumber: </td>
        <td>${requestScope["stores"].getPhoneNumberStore()}</td>
    </tr>
    <tr>
        <td>Delete By: </td>
        <td>${requestScope["stores"].getDeleteBy()}</td>
    </tr>
    <tr>
        <td>Delete Date: </td>
        <td>${requestScope["stores"].getDeleteDate()}</td>
    </tr>
    <tr>
        <td>Modify By: </td>
        <td>${requestScope["stores"].getModifyBy()}</td>
    </tr>
    <tr>
        <td>Modifi Date: </td>
        <td>${requestScope["stores"].getModifyDate()}</td>
    </tr>
    <tr>
        <td>Create By: </td>
        <td>${requestScope["stores"].getCreateBy()}</td>
    </tr>
    <tr>
        <td>Create Date: </td>
        <td>${requestScope["stores"].getCreateDate()}</td>
    </tr>
</table>
</body>
</html>
