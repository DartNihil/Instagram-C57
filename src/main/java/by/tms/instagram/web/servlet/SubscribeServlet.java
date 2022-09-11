package by.tms.instagram.web.servlet;

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

@WebServlet(value = "/subscribe", name = "SubscribeServlet")
public class SubscribeServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        Optional<User> user = userService.findByNickName(req.getParameter("nickname"));

        currentUser.getUserSubscriptions().add(user.get());
        user.get().getUserFollowers().add(currentUser);

        req.setAttribute("user" , user.get());
        getServletContext().getRequestDispatcher(Constant.USER_PAGE).forward(req, resp);
    }
}
