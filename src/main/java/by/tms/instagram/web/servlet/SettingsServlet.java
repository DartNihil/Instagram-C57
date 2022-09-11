package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.service.validator.SettingsValidator;
import by.tms.instagram.storage.InMemoryUserStorage;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/settings", name = "SettingsServlet")
public class SettingsServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = InMemoryUserStorage.getInstance();
    SettingsValidator settingsValidator = new SettingsValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constant.SETTINGS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentNickNameFromLogin = "currentNickNameFromLogin";
        if (!settingsValidator.allUserFieldsAreValid(req.getParameter("name"),
                req.getParameter("surname"), req.getParameter("nickname"),
                req.getParameter("email"))) {
            req.getServletContext().setAttribute("message", "the number of entered signs is exceeded or field doesn't correspond to validation ");
            resp.sendRedirect(Constant.SETTINGS_PAGE);
        }
        Optional<User> user = inMemoryUserStorage.findByNickName(req.getParameter("nickname"));
        if (user.isPresent()) {
            req.getServletContext().setAttribute("message", "Error! User with the same nickname exists");
            resp.sendRedirect(Constant.SETTINGS_PAGE);
        } else {
            inMemoryUserStorage.updateUser(req.getParameter("name"), req.getParameter("surname"),
                   currentNickNameFromLogin, req.getParameter("email"));
            resp.sendRedirect(Constant.SETTINGS_PAGE);
        }
    }
}
