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
    <title>DetailExportOrder List</title>
</head>
<body>
<h1>DetailExportOrder</h1>
<p>
    <a href="/exportOrder">Back to Export Order List</a>
</p>
<table border="1">
    <tr>
        <td>ID Export Order</td>
        <td>Export Order Name</td>
        <td>Phone Name</td>
        <td>Phone Amount</td>
        <td>Staff Name</td>
        <td>Stock Name</td>
        <td>Store Name</td>
        <td>Create By</td>
        <td>Create Date</td>
        <td>Modify By</td>
        <td>Modify Date</td>
        <td>Delete By</td>
        <td>Delete Date</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["detailExportOrders"]}' var="export">
        <tr>
                <%--            <td><a href="/exportOrder?action=view&id=${exportOrder.getIdExportOrder()}">${exportOrder.getName()}</a></td>--%>
            <td>${export.getIdExportOrder()}</td>
            <td>${export.getExportOrderName()}</td>
            <td>${export.getPhoneName()}</td>
            <td>${export.getPhoneAmount()}</td>
            <td>${export.getStaffName()}</td>
            <td>${export.getStockName()}</td>
            <td>${export.getStoreName()}</td>
            <td>${export.getCreateBy()}</td>
                    <td><c:if test="${not empty export.getCreateDate()}">
                        ${export.getCreateDate()}
                    </c:if>
                    </td>
            <td>${export.getModifyBy()}</td>
            <td>${export.getModifyDate()}</td>
            <td>${export.getDeleteBy()}</td>
            <td>${export.getDeleteDate()}</td>

<%--            <td><c:if test="${not empty detailExport.getCreateDate()}">--%>
<%--                ${detailExport.getCreateDate()}--%>
<%--            </c:if>--%>
<%--            </td>--%>
<%--            <td>${detailExport.getModifyBy()}</td>--%>
<%--            <td>${detailExport.getModifyDate()}</td>--%>
                <%--        <td></td>--%>
                <%--        <td></td>--%>
<%--            <td><a href="/exportOrder?action=edit&id=${detailExport.getIdExportOrder()}">edit</a></td>--%>
<%--            <td><a href="/exportOrder?action=delete&id=${detailExport.getIdExportOrder()}">delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>