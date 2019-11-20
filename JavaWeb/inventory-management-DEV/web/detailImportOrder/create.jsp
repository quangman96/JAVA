<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/10/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new importOrder</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
    <h1>Create new importOrder</h1>
    <p>
        <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/importOrders"> Back to importOder list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>ImportOrder information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>deleteBy: </td>
                    <td><input type="text" name="deleteBy" id="deleteBy"></td>
                </tr>
                <tr>
                    <td>deleteDate: </td>
                    <td><input type="text" name="deleteDate" id="deleteDate"></td>
                </tr>
                <tr>
                    <td>modifyBy: </td>
                    <td><input type="text" name="modifyBy" id="modifyBy"></td>
                </tr>
                <tr>
                    <td>modifyDate: </td>
                    <td><input type="text" name="modifyDate" id="modifyDate"></td>
                </tr>
                <tr>
                    <td>createBy: </td>
                    <td><input type="text" name="createBy" id="createBy"></td>
                </tr>
                <tr>
                    <td>createDate: </td>
                    <td><input type="text" name="createDate" id="createDate"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create importOrder"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
