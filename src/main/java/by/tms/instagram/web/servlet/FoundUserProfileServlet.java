package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/foundUserProfile", name = "FoundUserProfileServlet")
public class FoundUserProfileServlet extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        for (User user : inMemoryUserStorage.getUsers()) {
            if (user.getNickname().equals(nickname)) {
                req.setAttribute("user", user);
                break;
            }
        }
        req.getServletContext().getRequestDispatcher("/pages/profile.jsp").forward(req, resp);
    }
}
