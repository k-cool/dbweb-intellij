package com.sw.board.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user edit", value = "/user-edit")
public class AccountEditC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (AccountDAO.ACCOUNT_DAO.loginCheck(request)) {
            request.setAttribute("content", "jsp/account/mypage_edit.jsp");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (AccountDAO.ACCOUNT_DAO.loginCheck(request)) {
            AccountDAO.ACCOUNT_DAO.editUser(request);
        }

        response.sendRedirect("user-info");
    }

    public void destroy() {
    }
}