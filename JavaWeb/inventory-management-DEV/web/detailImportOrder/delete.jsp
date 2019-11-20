
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting importOrder</title>
</head>
<body>
<h1>Delete importOrder</h1>
<p>
    <a href="/importOrders">Back to importOrder list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>ImportOrder information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["importOrder"].getName()}</td>
            </tr>
            <tr>
                <td>DeleteBy: </td>
                <td>${requestScope["importOrder"].getDeleteBy()}</td>
            </tr>
            <tr>
                <td>DeleteDate: </td>
                <td>${requestScope["importOrder"].getDeleteDate()}</td>
            </tr>
            <tr>
                <td>ModifyBy: </td>
                <td>${requestScope["importOrder"].getModifyBy()}</td>
            </tr>
            <tr>
                <td>ModifyDate: </td>
                <td>${requestScope["importOrder"].getModifyDate()}</td>
            </tr>
            <tr>
                <td>CreateBy: </td>
                <td>${requestScope["importOrder"].getCreateBy()}</td>
            </tr>
            <tr>
                <td>CreateDate: </td>
                <td>${requestScope["importOrder"].getCreateDate()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete importOrder"></td>
                <td><a href="/importOrders">Back to importOrder list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
