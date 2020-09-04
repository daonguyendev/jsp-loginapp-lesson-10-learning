package com.daonguyen;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // transfer user's request to JSP to render user interface
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Step 1: Get login info from user's request
        // Get method from request
        System.out.println(req.getContextPath());

        // Get URL (action) from request
        System.out.println(req.getMethod());

        // Get user's info entered from form
        System.out.println(req.getServletPath());

        // Get parameter from input names
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Step 2: Validate login info
        // - Case 1: valid login info -> display message 'Login Successfully!' in console
        // - Case 2: invalid login info -> display message 'Login Failed. Incorrect email or password!' in console
        if (email.equals("admin@gmail.com") && password.equals("123456")) {
            System.out.println("Login Successfully!");

            // Add more info to request at loginServlet
            // - Will get this attribute if use forward
            // - Will NOT get this attribute if use redirect
            req.setAttribute("fullname", "Dao Nguyen");

//            // Using redirect to welcomeServlet
//            // => like reload page at URL: "../loginapp/welcome"
//            resp.sendRedirect(req.getContextPath() + "/welcome");

            // Using forward to welcomeServlet
            // => like continue use req, resp at loginServlet forward to welcomeServlet
            RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(req, resp);
        } else {
            System.out.println("Login Failed. Incorrect email or password!");
        }
    }
}
