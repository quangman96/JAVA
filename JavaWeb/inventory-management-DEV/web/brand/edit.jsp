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
    <title>Brand</title>
</head>
<body>
<h1>Edit Brand</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/brands">Back to Brand list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Brand information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["brand"].getName()}"></td>
            </tr>

            <tr>
                <td>Modify By: </td>
                <td><input type="text" name="modifyBy" id="modifyBy" value="${requestScope["brand"].getModifyBy()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update brand"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
