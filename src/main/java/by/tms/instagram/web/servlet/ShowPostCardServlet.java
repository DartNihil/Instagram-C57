package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserService;
import by.tms.instagram.service.UserServiceImpl;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showPostCard")
public class ShowPostCardServlet extends HttpServlet {
    private final UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postDate = req.getParameter("postDate");
        User user = (User) req.getSession().getAttribute("currentUser");
        Post post = userService.findPost(user, postDate);
        req.setAttribute("post", post);
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
