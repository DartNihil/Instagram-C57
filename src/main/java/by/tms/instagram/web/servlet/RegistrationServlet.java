package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserService;
import by.tms.instagram.service.validator.RegistrationValidator;
import by.tms.instagram.storage.InMemoryUserStorage;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = InMemoryUserStorage.getInstance();
    private final UserService userService = UserService.getInstance();
    private final RegistrationValidator validator = RegistrationValidator.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constant.REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validator.checkValidation(req.getParameter("nickname"),
                req.getParameter("name"), req.getParameter("surname"),
                req.getParameter("email"), req.getParameter("password"))) {
            req.getServletContext().setAttribute("mess", "Fields must not be empty");
            resp.sendRedirect(Constant.REGISTRATION_PAGE);
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

            String password = req.getParameter("password");
            List<String> nicknameWithTheSamePassword = inMemoryUserStorage.findNicknamesByTheSamePassword(password);
            if (!nicknameWithTheSamePassword.isEmpty()) {
                req.getServletContext().setAttribute("mess", "you have the same password with user " + nicknameWithTheSamePassword);
            }

            Optional<User> byUsername = userService.findByNickNameAndEmail(user.getEmail(), user.getNickname());
            if (byUsername.isPresent()) {
                req.setAttribute("mess", "User is already exist");
                getServletContext().getRequestDispatcher(Constant.REGISTRATION_PAGE).forward(req, resp);
            } else {
                userService.save(user);
                resp.sendRedirect(Constant.LOGIN_PAGE);
            }

        }
    }
}


