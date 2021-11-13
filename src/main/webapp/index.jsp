<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/app.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
    <title>Login Coffee Demo </title>
    <style>
        body{
            background-image: url(/assets/images/background/ca-phe.jpg);
        }
    </style>
</head>
<body>

<div id="wrapper" class="row">
    <div class="col-3"></div>
    <div class="col-6">
    <form action="/login" id="form-login" method="post">
        <h1 class="form-heading">COFFEE DEMO</h1>
        <div class="form-group">
            <i class="far fa-user"></i>
            <input type="text" class="form-input" name ="username" id="username" placeholder="Username">
        </div>
        <div class="form-group">
            <i class="fas fa-key"></i>
            <input type="password" class="form-input" name ="password" id="password" placeholder="Password">
            <div id="eye">
                <i class="far fa-eye"></i>
            </div>
        </div>
        <input type="submit" value="Login" class="form-submit">
    </form>
    </div>
    <div class="col-3">
        <p>
            <c:if test="${error!= null}">
                ${error}
            </c:if>
        </p>
    </div>

</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="/assets/js/app.js"></script>
</html>
</body>
</html>