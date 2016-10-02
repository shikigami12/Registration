package org.ua.deth.service;

import org.ua.deth.dao.DaoFactory;
import org.ua.deth.dao.UserDao;
import org.ua.deth.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp4) {
        HttpSession session = req.getSession(true);
        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDao = factory.getUserDao();
        if (session.getAttribute("user") == null) {
            User user = new User();
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            userDao.createUser(user);
            return "index.jsp";

        } else {
            List<User> users = userDao.getAll();
            session.setAttribute("users", users);
            return "users.jsp";
        }
    }
}
