package com.sw.board.jquery;

import com.sw.board.account.AccountDAO;
import com.sw.board.review.ReviewDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jquery", value = "/jquery")
public class JqueryC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("한글 깨지니?");

        request.getRequestDispatcher("jquery/jquery03.html").forward(request, response);

    }


    public void destroy() {
    }
}