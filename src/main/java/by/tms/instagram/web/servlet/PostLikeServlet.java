package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.Post;
import by.tms.instagram.entity.User;
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

@WebServlet("/postLike")
public class PostLikeServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final PostService postService = PostService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String postDate = req.getParameter("userPostDate");
        String email = req.getParameter("userEmail");
        Optional<User> userByEmail = userService.findByNickNameAndEmail("", email);
        User user = userByEmail.get();
        Post post = postService.findPost(userByEmail.get(), postDate);
        post = postService.likePost(user, currentUser, post, postDate);
        req.setAttribute("post", post);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);
    }
}
