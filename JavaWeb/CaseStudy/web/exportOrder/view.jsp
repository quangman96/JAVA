
<%--
  Created by IntelliJ IDEA.
  User: quangman
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Export</title>
</head>
<body>
<h1>Detail Export </h1>
<table>
    <tr>
        <td>ID Export: </td>
        <td>${requestScope["exportOrder"].getIdExportOrder()}</td>
    </tr>
    <tr>
        <td>Export Name: </td>
        <td>${requestScope["exportOrder"].getName()}</td>
    </tr>
    <tr>
        <td>Phone Name: </td>
        <td>${requestScope["exportOrder"].getNamePhone()}</td>
    </tr>
    <tr>
        <td>Phone Amount: </td>
        <td>${requestScope["exportOrder"].getPhoneAmount()}</td>
    </tr>
    <tr>
        <td>Store Name: </td>
        <td>${requestScope["exportOrder"].getNameStore()}</td>
    </tr>
    <tr>
        <td>Stock Name: </td>
        <td>${requestScope["exportOrder"].getNameStock()}</td>
    </tr>
    <tr>
        <td>Staff Name: </td>
        <td>${requestScope["exportOrder"].getNameStaff()}</td>
    </tr>
    <%--    <tr>--%>
    <%--        <td>Create By: </td>--%>
    <%--        <td>${requestScope["exportOrder"].getCreateBy()}</td>--%>
    <%--    </tr>--%>
    <%--    <tr>--%>
    <%--        <td>Create Date: </td>--%>
    <%--        <td>${requestScope["exportOrder"].getCreateDate()}</td>--%>
    <%--    </tr>--%>
    <%--    <tr>--%>
    <%--        <td>Modify By: </td>--%>
    <%--        <td>${requestScope["exportOrder"].getModifyBy()}</td>--%>
    <%--    </tr>--%>
    <%--    <tr>--%>
    <%--        <td>Modify By: </td>--%>
    <%--        <td>${requestScope["exportOrder"].getModifyDate()}</td>--%>
    <%--    </tr>--%>
</table>
</body>
</html>
