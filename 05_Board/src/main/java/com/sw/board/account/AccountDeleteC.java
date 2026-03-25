package com.sw.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user delete", value = "/user-delete")
public class AccountDeleteC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        if (AccountDAO.ACCOUNT_DAO.deleteUser(request)) {
            response.sendRedirect("main");
        } else {
            response.sendRedirect("user-info");
        }
    }

    public void destroy() {
    }
}