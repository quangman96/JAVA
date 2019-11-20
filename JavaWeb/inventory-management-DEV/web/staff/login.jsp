<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/16/2019
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../header.jsp"%>
<%--<body class="container-fluid">--%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    body {font-family: Arial, Helvetica, sans-serif;padding-top: 100px;}
    form {border: 1px solid #f1f1f1; margin: 0 auto;max-width: 500px;}
    div {
        background-image: url('codegym.jpg');
    }

    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        opacity: 0.8;
    }

    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    .container {
        padding: 16px;
    }

    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
</style>
<body>

<form action="/logins" method="post">
    <div class="imgcontainer">
        <img src="home/codegym.jpg" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="userName"><b>Username</b></label>
        <input  type="text" placeholder="Enter Username" name="userName" required placeholder="Enter email">

        <label for="psw"><b>Password</b></label>
        <input  type="password" placeholder="Enter Password" name="pass" required>

        <button type="submit" class="btn btn-primary">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>
<%--<form method="post" action="/logins">--%>

<%--    <%--%>
<%--        String value = (String)request.getAttribute("errorLogin");--%>
<%--        if(value != null){--%>

<%--    %>--%>
<%--    <p style="color: red; padding: 10px;">${errorLogin}</p>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>

<%--    <div class="form-group">--%>
<%--        <label for="exampleInputEmail1">UserName</label>--%>
<%--        <input name="userName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">--%>
<%--        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="exampleInputPassword1">Password</label>--%>
<%--        <input name="pass" type="pass" class="form-control" id="exampleInputPassword1" placeholder="Pass">--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--</form>--%>
</body>
</html>