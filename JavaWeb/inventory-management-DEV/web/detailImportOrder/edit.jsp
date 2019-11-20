
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit importOrder</title>
</head>
<body>
<h1>Edit importOrder</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/importOrders">Back to importOrder list</a>
</p>
<form method="post">
    <fieldset>
        <legend>ImportOrder information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["importOrder"].getName()}"></td>
            </tr>
            <tr>
                <td>DeleteBy: </td>
                <td><input type="text" name="deleteBy" id="deleteBy" value="${requestScope["importOrder"].getDeleteBy()}"></td>
            </tr>
            <tr>
                <td>DeleteDate: </td>
                <td><input type="text" name="deleteDate" id="deleteDate" value="${requestScope["importOrder"].getDeleteDate()}"></td>
            </tr>
            <tr>
                <td>ModifyBy: </td>
                <td><input type="text" name="modifyBy" id="modifyBy" value="${requestScope["importOrder"].getModifyBy()}"></td>
            </tr>
            <tr>
                <td>ModifyDate: </td>
                <td><input type="text" name="modifyDate" id="modifyDate" value="${requestScope["importOrder"].getModifyDate()}"></td>
            </tr>
            <tr>
                <td>CreateBy: </td>
                <td><input type="text" name="createBy" id="createBy" value="${requestScope["importOrder"].getCreateBy()}"></td>
            </tr>
            <tr>
                <td>CreateDate: </td>
                <td><input type="text" name="createDate" id="createDate" value="${requestScope["importOrder"].getCreateDate()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update importOrder"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
