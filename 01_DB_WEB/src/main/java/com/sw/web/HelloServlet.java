package com.sw.web;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home controller", value = "/show-all")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserDAO.showAllPeople(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("output.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            UserDAO.addUser(request);
            UserDAO.showAllPeople(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("output.jsp").forward(request, response);
    }

    public void destroy() {
    }
}