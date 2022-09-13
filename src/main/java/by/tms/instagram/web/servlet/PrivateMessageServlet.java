package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.entity.UserComposite;
import by.tms.instagram.entity.message.PrivateMessage;
import by.tms.instagram.service.MessageService;
import by.tms.instagram.service.UserService;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/privateMessage")
public class PrivateMessageServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private final MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        List<UserComposite> userComposites = userService.getSortedListOfUsersAndLastMessages(currentUser);
        String nickname = req.getParameter("nickname");
        User user;
        if(nickname != null) {
            user = userService.findByNickName(nickname).get();
        } else {
            user = userComposites.get(0).getUser();
        }
        List<PrivateMessage> listOfCurrentUser = currentUser.getPrivateMessages().get(user);
        List<PrivateMessage> listOfUser = currentUser.getPrivateMessages().get(currentUser);
        List<PrivateMessage> privateMessagesOfCurrentUser = messageService.setIsReadMessage(listOfCurrentUser, user);
        messageService.setIsReadMessage(listOfUser, currentUser);
        req.setAttribute("listOfUserComposites", userComposites);
        req.setAttribute("listOfPrivateMessages", privateMessagesOfCurrentUser);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher(Constant.PRIVATE_MESSAGES_PAGE).forward(req, resp);
    }
}
