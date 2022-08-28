<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 23.08.2022
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-50">
            <div class="col-md-7 col-lg-7 col-xl-5 my-4">
                <img src="https://pgdv.ru/images/blog/skryt-kommentarii-instagram/insta-001-min.jpg" class="img-fluid"
                     alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form>
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead fw-normal mb-0 me-3"></p>
                    </div>

                    <div class="divider d-flex align-items-center my-3">
                        <p class="text-center fw-bold mx-3 mb-2"></p>
                    </div>
                    <div class="fadeIn first">
                        <img src="https://espicture.ru/800/600/https/evo-lux.ru/image/catalog/banners_aurus/ssinstagram.png" />
                    </div>


                    <div class="form-outline mb-4 my-4">
                        <input type="nickname" id="form3Example3" class="form-control form-control-lg"
                               placeholder="Enter a valid nickname" />
                    </div>


                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" class="form-control form-control-lg"
                               placeholder="Enter password" />
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                        <a href="#!" class="text-body">Forgot password?</a>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="button" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="#!"
                                                                                          class="link-danger">Register</a></p>
                    </div>

                </form>
            </div>
        </div>
    </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<p>${requestScope.message}</p>
<p>${sessionScope.currentUser.nickname}</p>
<p>${sessionScope.currentUser.name}</p>
<p>${sessionScope.currentUser.surname}</p>
<p>${sessionScope.currentUser.email}</p>
<p>${sessionScope.currentUser.password}</p>
<p>${sessionScope.currentUser.id}</p>
<p>${sessionScope.currentUser.userRoleID}</p>
<p>${sessionScope.currentUser.userStatusID}</p>

<p>${sessionScope.message}</p>
<p>${response.message}</p>
<p>${requestScope.message}</p>

</body>
</html>
