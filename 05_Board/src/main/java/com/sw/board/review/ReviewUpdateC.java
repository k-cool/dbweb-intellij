package com.sw.board.review;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "review update", value = "/review-update")
public class ReviewUpdateC extends HttpServlet {
    public void init() {
        System.out.println("init method");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        ReviewDAO.REVIEW_DAO.getReview(request);

        request.setAttribute("content", "jsp/review/review_update.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        
        ReviewDAO.REVIEW_DAO.updateReview(request);

        response.sendRedirect("review-detail?no=" + request.getParameter("no"));
    }


    public void destroy() {
    }
}