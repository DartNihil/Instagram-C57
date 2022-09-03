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

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
    UserService userService = UserService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String postDate = req.getParameter("userPostDate");
        String email = req.getParameter("userEmail");
        Optional<User> userByEmail = userService.findByNickNameAndEmail("", email);
        User user = userByEmail.get();
        Post post = userService.findPost(userByEmail.get(), postDate);


        if (!post.getLikes().contains(currentUser)) {
            for (Post p:user.getUserPosts()) {
                if(p.getDateTime().toString().equals(postDate) ) {
                    p.getLikes().add(currentUser);
                    post = p;
                }
            }

        }
        else {

            for (Post p:user.getUserPosts()) {
                if(p.getDateTime().toString().equals(postDate) ) {

                    p.getLikes().remove(currentUser);
                    post = p;
                }
            }

        }

        req.setAttribute("post", post);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher(Constant.USER_POST_CARD).forward(req, resp);



    }
}
