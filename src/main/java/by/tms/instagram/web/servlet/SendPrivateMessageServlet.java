package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.PrivateMessage;
import by.tms.instagram.entity.User;
import by.tms.instagram.service.UserService;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet("/sendMessage")
public class SendPrivateMessageServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constant.PRIVATE_MESSAGES_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("privateMessage");
        User user = (User) req.getSession().getAttribute("user");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        PrivateMessage privateMessage = new PrivateMessage(LocalDateTime.now(), user, message);
        userService.addPrivateMessageInMap(currentUser, user, privateMessage);
        List<PrivateMessage> list = currentUser.getPrivateMessages().get(user);
        req.setAttribute("listOfPrivateMessages", list);
        getServletContext().getRequestDispatcher(Constant.PRIVATE_MESSAGES_PAGE).forward(req, resp);
    }
}
