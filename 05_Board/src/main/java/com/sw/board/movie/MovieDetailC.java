package com.sw.board.movie;

import com.sw.board.account.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "movie detail", value = "/detail-movie")
public class MovieDetailC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDAO.loginCheck(request);

        MovieDAO.movieDAO.getMovie(request);

        request.setAttribute("content", "jsp/movie/movie_detail.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDAO.movieDAO.addMovie(request);

        response.sendRedirect("movie");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/movie DELETE");
        MovieDAO.movieDAO.deleteMovie(request);
    }

    public void destroy() {
    }
}