<%--
  Created by IntelliJ IDEA.
  User: valen
  Date: 18.08.2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Registration</title>
    <style>
        .firstDiv img {
            max-width: 100%;
            height: auto;
            display: block;
        }

        .secondDiv p {
            font-size: 2vw;
            text-align: center;
            color: dimgrey;
        }

        .button-wrapper button {
            display: flex;
            justify-content: center;
            width: 100%;
        }

        hr {
            border: 1px solid #dcdcdc;
        }

        .between_horizontal_lines {
            text-align: center;
            margin: 0;
            font-size: medium;
        }

        .or {
            padding-top: 3px;
            color: dimgrey;
        }

    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center h-100">
        <div class="col-sm-5 bg-white">
            <form action="/reg" method="post">
                <div class="firstDiv">
                    <p>
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/600px-Instagram_logo.svg.png"
                             alt="Picture is loading"></p>
                </div>
                <div class="secondDiv">
                    <p>
                        Sign up to watch photos and videos of your friends
                    </p>
                </div>

                <div class="button-wrapper mb-3">
                    <a href="https://www.facebook.com/login.php">
                        <button type="button" class="btn btn-primary btn-block">
                            <span class="icon" style="font-size: medium"><i class="fa fa-facebook-square"></i></span>
                            Login via Facebook
                        </button>
                    </a>
                </div>
                <div class="row mb-3">
                    <div class="col-sm-5">
                        <hr>
                    </div>
                    <div class="col-sm-2 or">
                        <p class="between_horizontal_lines">OR</p>
                    </div>
                    <div class="col-sm-5">
                        <hr>
                    </div>
                </div>

                <div class="mb-3">
                    <input type="text" class="form-control" name="nickname" placeholder="Nickname">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="name" placeholder="Username">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="surname" placeholder="Surname">
                </div>
                <div class="mb-3">
                    <input type="email" class="form-control" name="email" placeholder="Email">
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>

                <div class="mb-3">
                    <div>
                        <p class="between_horizontal_lines" style="font-size: medium">People who use our service may
                            have uploaded your contact
                            information to Instagram.
                            <a href=""><strong>Learn more</strong></a>
                        </p>
                    </div>
                </div>

                <div class="mb-3">
                    <div>
                        <p class="between_horizontal_lines" style="font-size: medium">By registering, you accept our
                            <a href=""><strong>Terms</strong></a>,
                            <a href=""><strong>Privacy Policy</strong></a> and
                            <a href=""><strong>Cookie Policy</strong></a>.
                        </p>
                    </div>
                </div>
                <div class="form-row text-center">
                    <button class="btn btn-primary">Sign up</button>
                </div>

                <div class="mb-3">
                    <div>
                        <p class="between_horizontal_lines" style="font-size: medium">Do you have an account?
                            <a href="/pages/login.jsp" class=""><strong>Login</strong></a>
                        </p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<c:if test="${not empty mess}">
    <script>
        window.addEventListener("load",function(){
            alert("${mess}");
        })
    </script>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
