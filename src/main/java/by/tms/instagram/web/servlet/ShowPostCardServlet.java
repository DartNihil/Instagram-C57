package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserService;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/showPostCard")
public class ShowPostCardServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postDate = req.getParameter("postDate");
        String userEmail = req.getParameter("userEmail");
        Optional<User> userByEmail = userService.findByNickNameAndEmail("", userEmail);
        Post post = userService.findPost(userByEmail.get(), postDate);
        req.setAttribute("post", post);
        req.setAttribute("user", userByEmail.get());
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
