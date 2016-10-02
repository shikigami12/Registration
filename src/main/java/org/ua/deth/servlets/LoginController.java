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


@WebServlet("/loginHandler")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand("login");
        String page = command.execute(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
