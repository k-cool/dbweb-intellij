package com.sw.board.movie;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "movie edit", value = "/movie-edit")
public class MovieEditC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.ACCOUNT_DAO.loginCheck(request);

        MovieDAO.movieDAO.getMovie(request);

        request.setAttribute("content", "jsp/movie/movie_edit.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/movie-edit POST");

        request.setCharacterEncoding("UTF-8");

        MovieDAO.movieDAO.updateMovie2(request);

        System.out.println(request.getParameter("no"));

//        response.sendRedirect("detail-movie?no=" + request.getParameter("no"));
        response.sendRedirect("detail-movie?no=" + request.getAttribute("no"));

    }


    public void destroy() {
    }
}