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
import java.util.Set;

@WebServlet(value = "/found", name = "FoundUsersServlet")
public class FoundUsersServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String in = req.getParameter("in");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        Set<User> foundUsers = userService.checkCoincidencesInNamesAndSurnames(in, currentUser.getId());
        if(foundUsers.isEmpty()){
            req.setAttribute("message" , "No coincidences");
        }
        req.setAttribute("foundUsers", foundUsers);
        getServletContext().getRequestDispatcher(Constant.FOUND_USERS_PAGE).forward(req, resp);
    }
}