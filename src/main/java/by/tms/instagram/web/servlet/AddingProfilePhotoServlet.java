package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;
import by.tms.instagram.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProfilePhoto")
public class AddingProfilePhotoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constant.CURRENT_USER_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String srcAvatar = req.getParameter("srcAvatar");
        currentUser.setUserPhoto(srcAvatar);
        getServletContext().getRequestDispatcher(Constant.CURRENT_USER_PAGE).forward(req, resp);
    }
}
