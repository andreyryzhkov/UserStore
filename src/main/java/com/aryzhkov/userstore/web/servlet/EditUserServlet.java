package com.aryzhkov.userstore.web.servlet;

import com.aryzhkov.userstore.entity.User;
import com.aryzhkov.userstore.service.UserService;
import com.aryzhkov.userstore.web.templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EditUserServlet extends HttpServlet {

    private UserService userService;

    public EditUserServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);

        pageVariables.put("user", user);

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("edituser.html", pageVariables);
        response.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id")); // TODO: ID is not clear
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        User user = new User(id, firstName, lastName, salary);
        userService.UpdateUser(user);

        response.sendRedirect(request.getContextPath() + "/users");
    }
}
