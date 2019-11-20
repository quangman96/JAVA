<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>importOrder</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/CSS/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Mobile Warehouse Management </h1>
        <p>Create importOrder</p> 
    </div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="http://localhost:8080/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/phones">Phones</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/brands">Brands</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/exportOrder">ExportOrder</a>
            </li>  
            <li class="nav-item">
              <a class="nav-link" href="/importOrders">import Orders</a>
            </li> 
            <li class="nav-item">
              <a class="nav-link" href="/stores">Stores</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/stocks">Stocks</a>
            </li>  
          </ul>
        </div>  
    </nav>
<div class="container">
    <h1>Create new importOrder</h1>
        <div class="row">
            <c:if test='${requestScope["message"] != null}'>
                    <span class="message">
                        <div class="alert alert-success">
                            <strong>Success!</strong>${requestScope["message"]}
                        </div>
                    </span>
            </c:if>
        </div>
    <button type="button" class="btn btn-secondary">
        <a href="/importOrders">Back to ListImportOder</a>
    </button>
    
    <form method="post">
        <fieldset>
            <legend>ImportOrder information</legend>
            <div class="form-row">
                <label>Name:</label>
                <input type="text" class="form-control is-invalid" id="name" name="name" placeholder="Enter name ImportOrder" required>
                <div class="invalid-feedback">
                    Please provide a valid ImportOrder.
                </div>
            </div>
            <div class="form-row" >
                <label>NameStaff:</label>
                 <select id="idStaff" name="idStaff" class="custom-select">
                       <c:forEach items='${requestScope["staff"]}' var="staff">
                            <option value=${staff.getIdStaff()}>${staff.getName()}</option>
                        </c:forEach>
                </select>
            </div>
            <div class="form-row" >
                <label>NameStock:</label>
                 <select id="idStock" name="idStock" class="custom-select">
                       <c:forEach items='${requestScope["stock"]}' var="stock">
                        <option value=${stock.getIdStock()}>${stock.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>CreateBy:</label>
                <input type="text" class="form-control is-invalid" id="createBy" name="createBy" placeholder="Enter name creater" required>
                <div class="invalid-feedback">
                    Please provide a valid createBy.
                </div>
            </div>
            <div class="form-row">
                <label>store:</label>
                <select id="idPhone2" name="idPhone2" class="custom-select">
                    <c:forEach items='${requestScope["phoneList"]}' var="phone1">
                        <option value="${phone1.getIdPhone()}">${phone1.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-row">
                <label>Amount:</label>
                <input type="text" class="form-control is-invalid" id="AmountPhone" name="AmountPhone"
                       placeholder="Enter Amount Phone" required>
                <div class="invalid-feedback">
                    Please provide a valid Amount Phone.
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Create importOrder</button>
        </fieldset>
    </form>
</div>

</body>
</html>
