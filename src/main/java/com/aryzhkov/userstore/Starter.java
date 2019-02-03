package com.aryzhkov.userstore;

import com.aryzhkov.userstore.dao.UserStoreDao;
import com.aryzhkov.userstore.service.UserService;
import com.aryzhkov.userstore.web.servlet.GetUsersServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
    public static void main(String[] args) throws Exception {
        UserStoreDao userStoreDao = new UserStoreDao();
        UserService userService = new UserService();
        userService.setUserStoreDao(userStoreDao);

        GetUsersServlet getUsersServlet = new GetUsersServlet();
        getUsersServlet.setUserService(userService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(getUsersServlet), "/userstore");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}