package com.aryzhkov.userstore.web.servlet;

import com.aryzhkov.userstore.entity.User;
import com.aryzhkov.userstore.service.UserService;
import com.aryzhkov.userstore.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddUserServlet extends HttpServlet {

    private UserService userService;

    public AddUserServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();

        String page = pageGenerator.getPage("adduser.html", new HashMap<>());
        response.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        double salary = Double.parseDouble(request.getParameter("salary"));

        User user = new User(firstName, lastName, salary);
        userService.InsertUser(user);

        PageGenerator pageGenerator = PageGenerator.instance();

        String page = pageGenerator.getPage("adduser.html", new HashMap<>());
        response.getWriter().write(page);


        //    if (message == null || message.isEmpty()) {
        //        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //    } else {
        //        response.setStatus(HttpServletResponse.SC_OK);
        //    }

        //  pageVariables.put("message", message == null ? "" : message);

        //  response.getWriter().println(PageGenerator.instance().getPage("allusers.html", pageVariables));
    }
}
