package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.entity.UserComposite;
import by.tms.instagram.entity.message.PrivateMessage;
import by.tms.instagram.service.MessageService;
import by.tms.instagram.service.UserService;
import by.tms.instagram.service.validator.RegistrationValidator;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.tms.instagram.web.Constant.CURRENT_USER_PAGE;


@WebServlet(value = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final MessageService messageService = MessageService.getInstance();
    RegistrationValidator validator = RegistrationValidator.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!validator.loginValidation((req.getParameter("nickname")), (req.getParameter("password")))) {
            req.getServletContext().setAttribute("mess", "Fields must not be empty");
            resp.sendRedirect("/login");
        } else {

            Optional<User> user = userService.findByNickName(req.getParameter("nickname"));
            if (user.isPresent()) {
                if (req.getParameter("password").equals(user.get().getPassword())) {
                    User currentUser = user.get();
                    req.getSession().setAttribute("currentUser", currentUser);
                    if(currentUser.getPrivateMessages() != null) {

                        List<UserComposite> userComposites = userService.getSortedListOfUsersAndLastMessages(currentUser);
                        req.setAttribute("listOfUserComposites", userComposites);
                        int countOfUnreadMessages = messageService.getCountOfUnreadMessages(currentUser);
                        req.setAttribute("countOfUnreadMessages", countOfUnreadMessages);
                    }
                    getServletContext().getRequestDispatcher(CURRENT_USER_PAGE).forward(req, resp);
                } else {
                    req.getServletContext().setAttribute("mess", "Wrong password");
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } else {
                req.getServletContext().setAttribute("mess", "User not found");
                resp.sendRedirect(req.getContextPath() + "/reg");
            }
        }
    }
}
