package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.Comment;
import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.CommentService;
import by.tms.instagram.service.PostService;
import by.tms.instagram.service.UserService;
import by.tms.instagram.web.Constant;
import by.tms.instagram.web.facade.HelperLikesClass;
import by.tms.instagram.web.facade.LikesFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet("/commentLike")
public class CommentLikeServlet extends HttpServlet {
    private final LikesFacade likesFacade = new LikesFacade();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String postDate = req.getParameter("userPostDate");
        String commentDate = req.getParameter("postCommentDate");
        String email = req.getParameter("userEmail");
        HelperLikesClass helperLikesClass = likesFacade.getLikedObject(currentUser, email, postDate, commentDate);
        req.setAttribute("user", helperLikesClass.getUser());
        req.setAttribute("post", helperLikesClass.getPost());
        req.setAttribute("comment", helperLikesClass.getComment());
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
