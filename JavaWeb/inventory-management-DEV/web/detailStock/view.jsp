<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Detail Stock</title>
</head>
<body>
<h1>Detail Stock</h1>
<p>
    <a href="/detailstocks">Back to Detail Stock list</a>
</p>
<table>
    <tr>
        <td>PhoneAmount: </td>
        <td>${requestScope["detailStocks"].getPhoneAmount()}</td>
    </tr>
    <tr>
        <td>DeleteBy: </td>
        <td>${requestScope["detailStocks"].getDeleteBy()}</td>
    </tr>
    <tr>
        <td>DeleteDate: </td>
        <td>${requestScope["detailStocks"].getDeleteDate()}</td>
    </tr>
    <tr>
        <td>ModifyBy: </td>
        <td>${requestScope["detailStocks"].getModifyBy()}</td>
    </tr>
    <tr>
        <td>ModifyDate: </td>
        <td>${requestScope["detailStocks"].getModifyDate()}</td>
    </tr>
    <tr>
        <td>CreateBy: </td>
        <td>${requestScope["detailStocks"].getCreateBy()}</td>
    </tr>
    <tr>
        <td>CreateDate: </td>
        <td>${requestScope["detailStocks"].getCreateDate()}</td>
    </tr>
</table>
</body>
</html>
