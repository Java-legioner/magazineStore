package ua.ivashchuk.servlets;

import org.apache.log4j.Logger;
import ua.ivashchuk.dao.impl.UserDaoImpl;
import ua.ivashchuk.domain.User;
import ua.ivashchuk.domain.UserRole;
import ua.ivashchuk.service.UserService;
import ua.ivashchuk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserService();
    private static Logger LOGGER = Logger.getLogger(RegistrationServlet.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email  = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            userService.create(new User(firstName, lastName, email, password, UserRole.USER.toString()));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}

