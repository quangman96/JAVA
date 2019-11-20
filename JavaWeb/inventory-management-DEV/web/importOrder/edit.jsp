<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp" %>
<body>
<div class="container">
    <h1>Edit importOrder</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a class="btn btn-primary" href="/importOrders">Back to importOrder list</a>
    </p>
    <form method="post" class="form-inline">
        <fieldset>
            <legend>ImportOrder information</legend>
            <table class="table table-hover">

                <tr>
                    <th scope="col">Name:</th>
                    <td><input type="text" name="name" id="name" value="${requestScope["showEditImportOrder"].getName()}">
                    </td>
                </tr>
                <tr>
                    <th scope="col">ModifyBy:</th>
                    <td><input type="text" name="modifyBy" id="modifyBy"
                               value="${requestScope["showEditImportOrder"].getModifyBy()}"></td>
                </tr>
                <tr>
                    <th scope="col"></th>
                    <td><input type="submit" value="Update importOrder"></td>
                </tr>

            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
