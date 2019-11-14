<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quangman
  Date: 11/11/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/exportOrder">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Export Order information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["exportOrder"].getName()}</td>
<%--                <td>${requestScope["exportOrder"].getName()}</td>--%>
            </tr>
            <tr>
                <td>Delete By: </td>
                <td><input type="text" name ="deleteBy" id="deleteBy" value="${requestScope["exportOrder"].getDeleteBy()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete ExportOrder"></td>
<%--                <td><a href="/customers">Back to Export Order list</a></td>--%>
            </tr>
        </table>
    </fieldset>
</body>
</html>