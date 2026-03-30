package com.sw.board.review;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "review", value = "/review")
public class ReviewC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        int p = 1;

        if (request.getParameter("p") != null) {
            p = Integer.parseInt(request.getParameter("p"));
        }

        ReviewDAO.REVIEW_DAO.paging(p, request);
        
        request.setAttribute("content", "jsp/review/review.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    public void destroy() {
    }
}