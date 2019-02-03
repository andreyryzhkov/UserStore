package com.aryzhkov.userstore.web.servlet;

import com.aryzhkov.userstore.entity.User;
import com.aryzhkov.userstore.service.UserService;
import com.aryzhkov.userstore.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUsersServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getUsers();
        PageGenerator pageGenerator = PageGenerator.instance();

        Map<String, Object> map = new HashMap<>();
        map.put("users", users);

        String page = pageGenerator.getPage("index.html", map);
        resp.getWriter().write(page);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
