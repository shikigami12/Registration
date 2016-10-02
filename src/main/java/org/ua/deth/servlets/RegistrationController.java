package org.ua.deth.servlets;

import org.ua.deth.service.Command;
import org.ua.deth.service.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registrationHandler")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand("registration");
        String page = command.execute(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
