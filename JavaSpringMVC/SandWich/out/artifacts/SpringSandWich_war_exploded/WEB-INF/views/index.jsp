<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 29/11/2019
  Time: 2:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sand Wich</title>
</head>
<body>
        <h1>SandWich Condiments</h1>
        <form method="post" action="save">

        <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
        <input type="checkbox" name="condiment" value="Tomato"> Tomato
        <input type="checkbox" name="condiment" value="Mustard"> Mustard
        <input type="checkbox" name="condiment" value="Sprouts"> Sprouts

        <input type="submit" name="submit" value="OK">
    </form>

    <h2> Your choice</h2>
<%--        <c:forEach var="sw" items="${condiment}">--%>
<%--            <c:out value="${sw[0]}${sw[1]}"/>--%>
<%--        </c:forEach>--%>
${condiment[0]}
</body>
</html>
