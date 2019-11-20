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
    <title>Edit Detail Stock</title>
</head>
<body>
<h1>Edit Detail Stock</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/detailstocks">Back to stock list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Detail Stock information</legend>
        <table>
            <tr>
                <td>Phone Amount: </td>
                <td><input type="text" name="phoneAmount" id="phoneAmount" value="${requestScope["detailStock"].getPhoneAmount()}"></td>
            </tr>
            <tr>
                <td>Delete By: </td>
                <td><input type="text" name="deleteBy" id="deleteBy" value="${requestScope["detailStock"].getDeleteBy()}"></td>
            </tr>
            <tr>
                <td>Delete Date: </td>
                <td><input type="text" name="deleteDate" id="deleteDate" value="${requestScope["detailStock"].getDeleteDate()}"></td>
            </tr>
            <tr>
                <td>Modify By: </td>
                <td><input type="text" name="modifyBy" id="modifyBy" value="${requestScope["detailStock"].getModifyBy()}"></td>
            </tr>
            <tr>
                <td>Modify Date: </td>
                <td><input type="text" name="modifyDate" id="modifyDate" value="${requestScope["detailStock"].getModifyDate()}"></td>
            </tr>
            <tr>
                <td>Create By: </td>
                <td><input type="text" name="createBy" id="createBy" value="${requestScope["detailStock"].getCreateBy()}"></td>
            </tr>
            <tr>
                <td>Create Date: </td>
                <td><input type="text" name="createDate" id="createDate" value="${requestScope["detailStock"].getCreateDate()}"></td>
            </tr>
            <tr>
                <td>Submit</td>
                <td><input type="submit" value="Update Detail Stock"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

