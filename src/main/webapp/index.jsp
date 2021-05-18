<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>
    <style>
        <%@include file="/WEB-INF/css/login.css"%>
    </style>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
    <title>magazine shop</title>
</head>
<body>
<div class="container cont cont-login">
    <div class="frame">
        <div class="nav">
            <ul class="links">
                <li  class="signin-active"><a class="btn">Sign in</a></li>
                <li  class="signup-inactive"><a class="btn">Sign up </a></li>
            </ul>
        </div>
        <div ng-app ng-init="checked = false">
            <form class="form-signin" action="" method="post" name="form">
                <input  class="email form-styling" type="text"  placeholder="email"/>
                <input  class="password form-styling" type="text" name="password" placeholder="password"/>
                <div class="btn-animate"><a class="btn-signin">Sign in</a></div>
            </form>
            <form class="form-signup" action="" method="post" name="form">

                <input class="firstName form-styling" type="text"  placeholder="First name"/>

                <input class="lastName form-styling" type="text"  placeholder="last name"/>

                <input class="email form-styling" type="text"  placeholder="email"/>

                <input class="password form-styling" type="text"  placeholder="password"/>

                <a ng-click="checked = !checked" class="btn-signup">Sign Up</a>
            </form>
<%--            <div class="success">--%>
<%--                <svg width="270" height="270" xmlns="http://www.w3.org/2000/svg"--%>
<%--                     xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 60 60" id="check"--%>
<%--                     ng-class="checked ? 'checked' : ''"/>--%>
<%--                <path fill="#ffffff"--%>
<%--                      d="M40.61,23.03L26.67,36.97L13.495,23.788c-1.146-1.147-1.359-2.936-0.504-4.314 c3.894-6.28,11.169-10.243,19.283-9.348c9.258,1.021,16.694,8.542,17.622,17.81c1.232,12.295-8.683,22.607-20.849,22.042 c-9.9-0.46-18.128-8.344-18.972-18.218c-0.292-3.416,0.276-6.673,1.51-9.578"/>--%>
<%--                <div class="successtext">--%>
<%--                    <p> Thanks for signing up! Check your email for confirmation.</p>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="forgot"><a href="#">Forgot your password?</a></div>
<%--        <div>--%>
<%--            <div class="cover-photo"></div>--%>
<%--            <div class="profile-photo"></div>--%>
<%--            <h1 class="welcome">Welcome, Friend</h1> <a class="btn-goback" value="Refresh" onClick="history.go()">Go--%>
<%--            back</a>--%>
<%--        </div>--%>
    </div>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <b>Success!</b> You are registered.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script>
    <%@include file="/WEB-INF/js/login.js"%>
</script>

</body>
</html>