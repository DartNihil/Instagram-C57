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
    <title>Title</title>
</head>
<body>
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
