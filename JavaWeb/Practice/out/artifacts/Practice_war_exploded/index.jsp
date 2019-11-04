<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 04/11/2019
  Time: 2:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Currency Converter</title>--%>
<%--  <link rel="stylesheet" type="text/css" href="css/style.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Currency Converter</h2>--%>
<%--<form action="convert" method="post">--%>
<%--  <label>Rate: </label><br/>--%>
<%--  <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>--%>
<%--  <label>USD: </label><br/>--%>
<%--  <input type="text" name="usd" placeholder="USD" value="0"/><br/>--%>
<%--  <input type = "submit" id = "submit" value = "Converter"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Simple Dictionary</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="translate">
  <input type="text" name="txtSearch" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>