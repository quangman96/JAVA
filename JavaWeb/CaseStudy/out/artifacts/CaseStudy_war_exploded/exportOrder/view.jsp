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
    <title>View exportOrder</title>
</head>
<body>
<h1>exportOrder details</h1>
<p>
    <a href="/exportOrder">Back to exportOrder list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["exportOrder"].getName()}</td>
    </tr>
    <tr>
        <td>CreateBy: </td>
        <td>${requestScope["exportOrder"].getCreateBy()}</td>
    </tr>
</table>
</body>
</html>
