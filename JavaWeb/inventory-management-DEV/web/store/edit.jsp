<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 11/11/2019
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp" %>
<head>
    <title>Edit Store</title>
    <style>
        .message {
            color: blue;
        }
    </style>
</head>
<body>
<h1><span class="btn btn-info">Edit Store</span></h1>
<div class="alert alert-danger" role="alert">
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
</div>
<p>
    <a class="btn btn-primary" href="/stores" role="button">Back to Store</a>
</p>
<form method="post">
    <fieldset>
        <legend>Store information</legend>
        <table>

            <div class="input-group mb-3">
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Name Store</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="nameStore" name="nameStore" value="${requestScope["stores"].getNameStore()}">
                    </td>
                </tr>
                <tr>
                                      <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Address Store</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="addressStore" name="addressStore"
                               value="${requestScope["stores"].getAddressStore()}">
                    </td>
                </tr>
                <tr>
                                      <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">PhoneNumber: </span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="PhoneNumberStore" name="PhoneNumberStore"
                               value="${requestScope["stores"].getPhoneNumberStore()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="input-group-prepend">
                            <span class="input-group-text">Modify By: </span>
                        </div>
                        <input type="text" class="form-control" aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default"
                               id="modifyBy" name="modifyBy">
                    </td>
                </tr>
            </div>
            <tr>
                <td>
                    <button type="submit" class="btn btn-success">Update Store</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
