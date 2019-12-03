<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 22/11/2019
  Time: 3:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/current">
        <table>
            <tr>
                <td>USD</td>
                <td><input type="number" name="usd"> USD</td>
            </tr>
            ${result}
            <tr>
                <td><input type="submit" value="Convert"></td>
            </tr>
        </table>
    </form>
</body>
</html>
