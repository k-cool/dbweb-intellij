package com.sw.board.review;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "review add", value = "/review-add")
public class ReviewAddC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        request.setAttribute("content", "jsp/review/review_add.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        ReviewDAO.REVIEW_DAO.addReview(request);

        response.sendRedirect("review");
    }


    public void destroy() {
    }
}