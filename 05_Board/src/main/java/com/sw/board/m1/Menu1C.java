package com.sw.board.m1;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menu1", value = "/menu1")
public class Menu1C extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.loginCheck(request);

        request.setAttribute("content", "jsp/m1/menu1.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}