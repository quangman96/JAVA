<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp" %>
<div class="alert alert-secondary" role="alert">
    <head>
        <title>detailExportOrder list</title>
    </head>
    <body>
    <h1> <span class="badge badge-secondary">Detail ExportOrder  </span></h1>

    <table class="table">

        <tr>
            <%--            <td>name Store</td>--%>
                <td scope="col">Phone Name</td>
                <td scope="col" >Phone Number</td>
                <td scope="col" >Phone Amount</td>
                <td scope="col">Staff Name</td>
                <td scope="col" >Stock Number</td>
                <td scope="col" >Store Number</td>
                <td scope="col">Create By</td>
                <td scope="col" >Create Date</td>
                <td scope="col" >Modify By</td>
                <td scope="col" >Modify Date</td>

        </tr>
        <c:forEach items='${requestScope["detailExportOrder"]}' var="de">
            <tr>
                    <%--            <td>${detailstore1.getNameStore()}</td>--%>
                <td>${de.getIdExportOrder()}</td>
                <td>${de.getPhoneName()}</td>
                <td>${de.getPhoneAmount()}</td>
                <td>${de.getStaffName()}</td>
                <td>${de.getStockName()}</td>
                <td>${de.getStoreName()}</td>
                <td>${de.getCreateBy()}</td>
                <td>${de.getCreateDate()}</td>
                <td>${de.getModifyBy()}</td>
                <td>${de.getModifyDate()}</td>


            </tr>
        </c:forEach>
    </table>
    </body>
</div>
</html>
