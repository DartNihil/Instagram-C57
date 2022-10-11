package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.web.Constant;
import by.tms.instagram.web.facade.privateMessagesFacade.HelperPrivateMessagesClass;
import by.tms.instagram.web.facade.privateMessagesFacade.PrivateMessagesFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/privateMessage")
public class PrivateMessageServlet extends HttpServlet {
    PrivateMessagesFacade privateMessagesFacade = new PrivateMessagesFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String nickname = req.getParameter("nickname");
        HelperPrivateMessagesClass helperPrivateMessagesClass = privateMessagesFacade.getListsOfMessages(nickname, currentUser);
        req.setAttribute("listOfUserComposites", helperPrivateMessagesClass.getUserComposites());
        req.setAttribute("listOfPrivateMessages", helperPrivateMessagesClass.getPrivateMessagesOfCurrentUser());
        req.setAttribute("user", helperPrivateMessagesClass.getUser());
        getServletContext().getRequestDispatcher(Constant.PRIVATE_MESSAGES_PAGE).forward(req, resp);
    }
}
