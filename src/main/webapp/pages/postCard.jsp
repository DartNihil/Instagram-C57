<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.09.2022
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>postCard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<%--Simple post card with basic components--%>
<div class="container text-center">
    <div class="row justify-content-center">
        <div class="col mt-5">
            <div class="card" style="width: 18rem;">
                <img src="${post.picture}" class="card-img-top" alt="...">
                <div class="card-body">

                    <%--JSP for likes and display likes list--%>
                    <form action="/postLike" method="post">
                        <input type="hidden" name="userEmail" value="${user.email}">
                        <input type="hidden" name="userPostDate" value="${post.dateTime}">
                        <c:if test="${user != currentUser}">
                            <c:if test="${!post.getLikes().contains(currentUser)}">
                                <button class="btn btn-light">Like!</button>
                            </c:if>
                            <c:if test="${post.getLikes().contains(currentUser)}">
                                <button class="btn btn-danger">Like!</button>
                            </c:if>
                        </c:if>
                    </form>
                    <button data-bs-toggle="modal" data-bs-target="#postLikeListModal">${post.getLikes().size()} likes
                    </button>
                    <%-- End of JSP for likes and display likes list--%>

                    <p class="card-text">${post.dateTime}</p>
                    <p class="card-text">${post.description}</p>

                    <%--Comments with likes and display likes list without adding servlet--%>
                    <c:forEach items="${post.comments}" var="comment">
                        <li class="list-group-item">
                                ${comment.dateTime}
                            <img src="${comment.author.userPhoto}"
                                 class="rounded-circle"
                                 height="40" width="40" alt="..."/>
                                ${comment.author.fullName}
                                ${comment.text}
                            <form action="/commentLike" method="post">
                                <input type="hidden" name="userEmail" value="${user.email}">
                                <input type="hidden" name="userPostDate" value="${post.dateTime}">
                                <input type="hidden" name="postCommentDate" value="${comment.dateTime}">
                                <c:if test="${comment.author != currentUser}">
                                    <c:if test="${!comment.getLikes().contains(currentUser)}">
                                        <button class="btn btn-light">Like!</button>
                                    </c:if>
                                    <c:if test="${comment.getLikes().contains(currentUser)}">
                                        <button class="btn btn-danger">Like!</button>
                                    </c:if>
                                </c:if>
                            </form>
                            <form action="/showCommentLikes">
                                <input type="hidden" name="userEmail" value="${user.email}">
                                <input type="hidden" name="userPostDate" value="${post.dateTime}">
                                <input type="hidden" name="postCommentDate" value="${comment.dateTime}">
                                <button>${comment.getLikes().size()} likes</button>
                            </form>
                        </li>
                    </c:forEach>
                    <form>
                        <input type="text" class="form-control" id="inputComment" name="text"
                               placeholder="Enter your comment...">
                        <button>Add comment</button>
                    </form>
                        <%--End comments with likes and display likes list without adding servlet--%>
                </div>
            </div>
        </div>
    </div>
</div>

<%--Modal to display post likes list--%>
<div class="modal fade" id="postLikeListModal" tabindex="-1" aria-labelledby="likeListModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="likeListModalLabel">Likes list</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <c:forEach items="${post.likes}" var="userLike">
                    <div class="col-sm-3">
                        <div class="myDiv1">
                            <form action="/foundUserProfile">
                                <button>
                                    <input type="hidden" name="nickname" value="${userLike.nickname}">
                                    <li class="list-group-item">
                                        <img src="${userLike.userPhoto}"
                                             class="rounded-circle"
                                             height="40" width="40" alt="..."/>
                                            ${userLike.name} ${userLike.surname}
                                    </li>
                                </button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<%--End of modal to display likes list--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
