package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.web.Constant;
import by.tms.instagram.web.facade.likesFacade.HelperLikesClass;
import by.tms.instagram.web.facade.likesFacade.LikesFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postLike")
public class PostLikeServlet extends HttpServlet {
    private final LikesFacade likesFacade = new LikesFacade();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String postDate = req.getParameter("userPostDate");
        String email = req.getParameter("userEmail");
        HelperLikesClass helperLikesClass = likesFacade.getLikedObject(currentUser, email, postDate);
        req.setAttribute("user", helperLikesClass.getUser());
        req.setAttribute("post", helperLikesClass.getPost());
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
