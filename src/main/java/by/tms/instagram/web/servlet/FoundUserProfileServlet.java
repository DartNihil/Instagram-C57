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

@WebServlet(value = "/foundUserProfile", name = "FoundUserProfileServlet")
public class FoundUserProfileServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> user = userService.findByNickName(req.getParameter("nickname"));
        user.ifPresent(value -> req.setAttribute("user", value));
        req.getServletContext().getRequestDispatcher(Constant.USER_PAGE).forward(req, resp);
    }
}
