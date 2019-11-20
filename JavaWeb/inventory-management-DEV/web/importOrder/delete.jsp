<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <p>Delete Brand</p>
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
                <a class="nav-link" href="/exportOrder">Export Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/importOrders">Import Order</a>
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
    <h1>Delete importOrder</h1>
    <p>
        <a href="/importOrders" class="btn btn-primary" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample">Back to importOrder list</a>
    </p>
    <form method="post" class="form-inline">

        <fieldset>
            <legend>ImportOrder information, Are you sure? </legend>

            <table class="table table-hover">
                <tr>
                    <th scope="col">Name:</th>
                    <td>${requestScope["deleteImportOrder"].getName()}</td>
                </tr>
                <tr>
                    <th scope="col">NameStaff:</th>
                    <td>${requestScope["deleteImportOrder"].getIdStaff()}</td>
                </tr>
                <tr>
                    <th scope="col">NameStock:</th>
                    <td>${requestScope["deleteImportOrder"].getIdStock()}</td>
                </tr>
                <tr>
                    <th scope="col">DeleteBy:</th>
                    <td>${requestScope["deleteImportOrder"].getDeleteBy()}</td>
                </tr>
                <tr>
                    <th scope="col">DeleteDate:</th>
                    <td>${requestScope["deleteImportOrder"].getDeleteDate()}</td>
                </tr>
                <tr>
                    <th scope="col">ModifyBy:</th>
                    <td>${requestScope["deleteImportOrder"].getModifyBy()}</td>
                </tr>
                <tr>
                    <th scope="col">ModifyDate:</th>
                    <td>${requestScope["deleteImportOrder"].getModifyDate()}</td>
                </tr>
                <tr>
                    <th scope="col">CreateBy:</th>
                    <td>${requestScope["deleteImportOrder"].getCreateBy()}</td>
                </tr>
                <tr>
                    <th scope="col">CreateDate:</th>
                    <td>${requestScope["deleteImportOrder"].getCreateDate()}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete importOrder"></td>
                </tr>
            </table>
        </fieldset>
    </form>

</div>

</body>
</html>
