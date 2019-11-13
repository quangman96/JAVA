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
    <title>Create new ExportOrder</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Create new ExportOrder</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/exportOrder">Back to ExportOrder list</a>
</p>
<form method="post">
    <fieldset>
        <legend>ExportOrder information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>CreateBy: </td>
                <td><input type="text" name="createBy" id="createBy"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create exportOrder"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
