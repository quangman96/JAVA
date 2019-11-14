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
    <title>Edit exportOrder</title>
</head>
<body>
<h1>Edit exportOrder</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/exportOrder">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>exportOrder information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["exportOrder"].getName()}"></td>
            </tr>
            <tr>
                <td>Modify By: </td>
                <td><input type="text" name="modifyBy" id="modifyBy" value="${requestScope["exportOrder"].getModifyBy()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="UPDATE"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
