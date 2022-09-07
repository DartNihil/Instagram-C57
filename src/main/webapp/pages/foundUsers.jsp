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

<!-- Navbar starts -->
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">

        <div class="collapse navbar-collapse justify-content-center" id="navbarCenteredExample">
            <div class="container">
                <div class="row">
                    <!-- Instagram logo , clickable source + img source -->
                    <div class="col-md-5">
                        <a class="navbar-brand" href="/pages/homepage.jsp">
                            <img src="https://www.instagram.com/static/images/web/mobile_nav_type_logo.png/735145cfe0a4.png"
                                 height="30" style="margin-top: 1rem" alt=""/>
                        </a>
                    </div>
                    <!-- Search field and button -->
                    <div class="col-md-3">
                        <form action="/found" class="d-flex input-group w-auto" style="padding-top:10px">
                            <input type="search" name="in" class="form-control me-2">
                            <button class="btn btn-outline-dark" type="submit">Search</button>
                        </form>
                    </div>

                    <!-- Icons with sources -->
                    <div class="col-md-3">
                        <ul class="navbar-nav justify-content-center">
                            <!-- Home -->
                            <li class="nav-item me-3 me-lg-0">
                                <a class="nav-link" href="/pages/homepage.jsp">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                         class="bi bi-house-door-fill" viewBox="0 0 16 16">
                                        <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5z"/>
                                    </svg>
                                </a>
                            </li>
                            <!-- Flying plane -->
                            <li class="nav-item me-3 me-lg-0">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-telegram" viewBox="0 0 16 16">
                                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.287 5.906c-.778.324-2.334.994-4.666 2.01-.378.15-.577.298-.595.442-.03.243.275.339.69.47l.175.055c.408.133.958.288 1.243.294.26.006.549-.1.868-.32 2.179-1.471 3.304-2.214 3.374-2.23.05-.012.12-.026.166.016.047.041.042.12.037.141-.03.129-1.227 1.241-1.846 1.817-.193.18-.33.307-.358.336a8.154 8.154 0 0 1-.188.186c-.38.366-.664.64.015 1.088.327.216.589.393.85.571.284.194.568.387.936.629.093.06.183.125.27.187.331.236.63.448.997.414.214-.02.435-.22.547-.82.265-1.417.786-4.486.906-5.751a1.426 1.426 0 0 0-.013-.315.337.337 0 0 0-.114-.217.526.526 0 0 0-.31-.093c-.3.005-.763.166-2.984 1.09z"/>
                                    </svg>
                                </a>
                            </li>
                            <!-- Plus -->
                            <li class="nav-item me-3 me-lg-0">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                                        <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                                    </svg>
                                </a>
                            </li>
                            <!-- Compass -->
                            <li class="nav-item me-3 me-lg-0">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-compass-fill" viewBox="0 0 16 16">
                                        <path d="M15.5 8.516a7.5 7.5 0 1 1-9.462-7.24A1 1 0 0 1 7 0h2a1 1 0 0 1 .962 1.276 7.503 7.503 0 0 1 5.538 7.24zm-3.61-3.905L6.94 7.439 4.11 12.39l4.95-2.828 2.828-4.95z"/>
                                    </svg>
                                </a>
                            </li>
                            <!-- Heart -->
                            <li class="nav-item me-3 me-lg-0">
                                <a class="nav-link" href="#likesHistoryModal" data-bs-toggle="modal">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                                         class="bi bi-heart-fill" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                              d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
                                    </svg>
                                </a>
                            </li>

                            <!-- Avatar with dropdown menu with source links-->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <%--View small avatar photo at navbar--%>
                                    <c:if test="${sessionScope.currentUser.userPhoto == null}">
                                        <img src="https://img.freepik.com/premium-vector/figure-of-a-person-hand-drawn-outline-doodle-icon-sketch-illustration-of-a-standing-figure-for-print-web-mobile-and-infographics-isolated-on-white-background_107173-17483.jpg"
                                             class="rounded-circle" height="40" width="40" alt=""/>
                                    </c:if>
                                    <c:if test="${sessionScope.currentUser.userPhoto != null}">
                                        <img src="${sessionScope.currentUser.userPhoto}" class="rounded-circle"
                                             height="40" width="40" alt=""/>
                                    </c:if>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/pages/currentUserProfile.jsp">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                                        </svg> My profile </a></li>
                                    <li><a class="dropdown-item" href="/settings">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-gear" viewBox="0 0 16 16">
                                            <path d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z"/>
                                            <path d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z"/>
                                        </svg> Settings </a></li>
                                    <li><a class="dropdown-item" href="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-file-arrow-down" viewBox="0 0 16 16">
                                            <path d="M8 5a.5.5 0 0 1 .5.5v3.793l1.146-1.147a.5.5 0 0 1 .708.708l-2 2a.5.5 0 0 1-.708 0l-2-2a.5.5 0 1 1 .708-.708L7.5 9.293V5.5A.5.5 0 0 1 8 5z"/>
                                            <path d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
                                        </svg> Saved </a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="/logout">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                                            <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                                        </svg> Logout </a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </div>
</nav>
<!-- Navbar ends -->

<h3>Found users</h3>
<ul class="list-group">
    <c:forEach var="user" items="${foundUsers}">
        <div class="col-3">
            <form action="/foundUserProfile">
                <button class="btn btn-primary" name="nickname" value="${user.nickname}">
                    <li class="list-group-item">
                        <img src="${user.userPhoto}"
                             class="rounded-circle"
                             height="40" width="40" alt="..."/>
                            ${user.name} ${user.surname}
                    </li>
                </button>
            </form>
        </div>
    </c:forEach>
</ul>
<p>${message}</p>

<div class="modal fade" id="likesHistoryModal" tabindex="-1" aria-labelledby="likesHistoryModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="likesHistoryModalLabel">Likes history</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:forEach items="${sessionScope.currentUser.getReverseLikesHistory()}" var="like">
                    <c:if test="${like.comment == null}">
                        <p><img src="${like.author.userPhoto}" class="rounded-circle"
                                height="40" width="40" alt="..."> ${like.author.name} ${like.author.surname} likes your post
                            <img src="${like.post.picture}" class="rounded" height="40" width="40" alt="..."></p>
                    </c:if>
                    <c:if test="${like.post == null}">
                        <p>
                            <img src="${like.author.userPhoto}" class="rounded-circle"
                                 height="40" width="40" alt="..."> ${like.author.name} ${like.author.surname} likes your comment
                            "${like.comment.text}" to post
                            <img src="${like.commentPost.picture}" class="rounded" height="40" width="40" alt="...">
                        </p>
                    </c:if>
                </c:forEach>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>