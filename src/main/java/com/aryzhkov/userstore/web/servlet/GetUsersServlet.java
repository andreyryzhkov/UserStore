package com.aryzhkov.userstore.web.servlet;

import com.aryzhkov.userstore.entity.User;
import com.aryzhkov.userstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getUsers();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
