package com.sw.board.main;

import com.sw.board.account.AccountDAO;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "main", value = "/main")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("main 돌아써용~!");

        AccountDAO.loginCheck(request);

        request.setAttribute("content", "home.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}