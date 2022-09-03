package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.Comment;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.CommentService;
import by.tms.instagram.service.PostService;
import by.tms.instagram.service.UserService;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/commentLike")
public class CommentLikeServlet extends HttpServlet {
    UserService userService = UserService.getInstance();
    PostService postService = PostService.getInstance();
    CommentService commentService = CommentService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String postDate = req.getParameter("userPostDate");
        String commentDate = req.getParameter("postCommentDate");
        String email = req.getParameter("userEmail");
        Optional<User> userByEmail = userService.findByNickNameAndEmail("", email);
        User user = userByEmail.get();
        Post post = postService.findPost(userByEmail.get(), postDate);
        Comment comment = commentService.findComment(post, commentDate);
        comment = commentService.likeComment(post, currentUser, comment, commentDate);
        req.setAttribute("post", post);
        req.setAttribute("user", user);
        req.setAttribute("comment", comment);
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
