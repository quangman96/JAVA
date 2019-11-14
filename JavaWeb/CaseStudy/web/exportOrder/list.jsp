<%--
  Created by IntelliJ IDEA.
  User: quangman
  Date: 11/11/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ExportOrder List</title>
</head>
<body>
<h1>ExportOrder</h1>
<p>
    <a href="/exportOrder?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>NameStaff</td>
        <td>NameStock</td>
        <td>NameStore</td>
<%--        <td>DeleteBy</td>--%>
<%--        <td>DeleteDay</td>--%>
        <td>CreateBy</td>
        <td>CreateDate</td>
        <td>ModifyBy</td>
        <td>ModifyDate</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["exportOrders"]}' var="export">
        <tr>
<%--            <td><a href="/exportOrder?action=view&id=${exportOrder.getIdExportOrder()}">${exportOrder.getName()}</a></td>--%>
            <td>${export.getIdExportOrder()}</td>
            <td>${export.getName()}</td>
            <td></td>
            <td></td>
            <td></td>
<%--            <td></td>--%>
<%--            <td></td>--%>
            <td>${export.getCreateBy()}</td>
            <td><c:if test="${not empty export.getCreateDate()}">
                ${export.getCreateDate()}
                </c:if>
            </td>
            <td>${export.getModifyBy()}</td>
            <td>${export.getModifyDate()}</td>
<%--        <td></td>--%>
<%--        <td></td>--%>
            <td><a href="/exportOrder?action=edit&id=${export.getIdExportOrder()}">edit</a></td>
            <td><a href="/exportOrder?action=delete&id=${export.getIdExportOrder()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>