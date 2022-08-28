package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserServiceImpl;
import by.tms.instagram.service.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(value = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();
    RegistrationValidator validator = new RegistrationValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!validator.loginValidation((req.getParameter("nickname")), (req.getParameter("password")))) {
            req.getServletContext().setAttribute("mess", "Fields must not be empty");
            resp.sendRedirect("/login");
        } else {

            Optional<User> user = userServiceImpl.findByNickName(req.getParameter("nickname"));
            if (user.isPresent()) {
                if (req.getParameter("password").equals(user.get().getPassword())) {
                    req.getSession().setAttribute("currentUser", user);
                    resp.sendRedirect("/pages/homepage.jsp");
                } else {
                    req.setAttribute("message", "Wrong password");
                    getServletContext().getRequestDispatcher("/login").forward(req, resp);
                }
            }
        }
    }
}
