package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.message.Comment;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.MessageService;
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

@WebServlet("/showCommentLikes")
public class ShowCommentLikesServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final PostService postService = PostService.getInstance();
    private final MessageService messageService = MessageService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postDate = req.getParameter("userPostDate");
        String userEmail = req.getParameter("userEmail");
        String commentDate = req.getParameter("postCommentDate");
        Optional<User> userByEmail = userService.findByNickNameAndEmail(userEmail, "");
        Post post = postService.findPost(userByEmail.get(), postDate);
        Comment comment = messageService.findComment(post, commentDate);
        req.setAttribute("comment", comment);
        getServletContext().getRequestDispatcher(Constant.COMMENT_LIKES_PAGE).forward(req, resp);
    }
}
