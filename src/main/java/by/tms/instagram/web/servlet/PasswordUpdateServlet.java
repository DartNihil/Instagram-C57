package by.tms.instagram.web.servlet;

import by.tms.instagram.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/password/change")
public class PasswordUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/passwordUpdate.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder().password(req.getParameter("password")).build();
        req.getSession().getAttribute("currentUser");
        String password = user.getPassword();

        String oldPassword, newPassword, confirmNewPassword;

        oldPassword = req.getParameter("password");
        newPassword = req.getParameter("newPassword");
        confirmNewPassword = req.getParameter("confirmNewPassword");

        if (Objects.equals(oldPassword, password) &&
                !Objects.equals(password, newPassword) &&
                Objects.equals(newPassword, confirmNewPassword)) {
            user.setPassword(newPassword);
            resp.sendRedirect("/settings");
        } else resp.sendRedirect("/password/change");
    }
}
