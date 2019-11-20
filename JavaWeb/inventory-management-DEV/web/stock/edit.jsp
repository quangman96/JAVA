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
    <title>Edit Stock</title>
</head>
<body>
<h1>Edit Stock</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/stocks">Back to stock list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Stock information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["stock"].getName()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope["stock"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="phoneNumber" id="phoneNumber" value="${requestScope["stock"].getPhoneNumber()}"></td>
            </tr>
            <tr>
                <td>Modify By: </td>
                <td><input type="text" name="modifyBy" id="modifyBy" value="${requestScope["stock"].getModifyBy()}"></td>
            </tr>
            <tr>
                <td>Submit</td>
                <td><input type="submit" value="Update stock"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

