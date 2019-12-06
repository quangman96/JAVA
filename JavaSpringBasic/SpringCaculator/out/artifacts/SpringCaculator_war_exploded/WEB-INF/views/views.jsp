<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 29/11/2019
  Time: 4:22 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/result">
        <input type="text" name="text1" id="text1">
        <input type="text" name="text2" id="text2">
        <input type="submit" name="operator" value="cong">
        <input type="submit" name="operator" value="tru">
        <input type="submit" name="operator" value="nhan">
        <input type="submit" name="operator" value="chia">

    </form>
    ${result}
</body>
</html>
