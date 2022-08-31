<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>FoundUsers</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<h3>Found users</h3>
<form action="/found" method="post">
    <div class="list-group">
        <c:forEach var="u" items="${foundUsers}">
            <div class="col-4 text-left">
                <a href="#" class="list-group-item list-group-item-action">
                    <!-- Here will be $ {user."profilePicture"} -->
                    <img src="https://img.informer.com/icons_mac/png/128/546/546868.png" class="rounded-circle"
                         height="40" width="40" alt=""/>
                        ${u.name} ${u.surname}</a>
            </div>
        </c:forEach>
    </div>
    <p>${message}</p>
    <a href="#" class="btn btn-primary" style="margin-left: 8px">Back</a>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>