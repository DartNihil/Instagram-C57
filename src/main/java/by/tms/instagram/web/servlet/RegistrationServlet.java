package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserService;
import by.tms.instagram.service.validator.RegistrationValidator;
import by.tms.instagram.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();
    RegistrationValidator validator = new RegistrationValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validator.checkValidation(req.getParameter("nickname"),
                req.getParameter("name"), req.getParameter("surname"),
                req.getParameter("email"))) {
            req.getServletContext().setAttribute("mess", "Fields must not be empty");
            //getServletContext().getRequestDispatcher("/pages/reg.jsp");
            resp.sendRedirect("/pages/reg.jsp");
        } else {
            User user = User.builder()
                    .nickname(req.getParameter("nickname"))
                    .name(req.getParameter("name"))
                    .surname(req.getParameter("surname"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .userRoleID(2)
                    .userStatusID(1)
                    .build();

            Optional<User> byUsername = userService.findByNickNameAndEmail(user.getEmail(), user.getNickname());
            req.getSession().setAttribute("currentUser", user);

            if (byUsername.isPresent()) {
                req.setAttribute("mess", "User is already exist");
                getServletContext().getRequestDispatcher("/pages/reg.jsp");
            } else {
                userService.save(user);
                resp.sendRedirect("/pages/login.jsp");
            }
        }
    }
}


