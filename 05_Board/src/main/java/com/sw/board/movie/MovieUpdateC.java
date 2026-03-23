package com.sw.board.movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "movie update", value = "/movie-update")
public class MovieUpdateC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDAO.movieDAO.getMovie(request);

        request.setAttribute("content", "jsp/movie/movie_update.jsp");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("/movie-update POST");

        request.setCharacterEncoding("UTF-8");

        MovieDAO.movieDAO.updateMovie(request);

        response.sendRedirect("detail-movie?no=" + request.getParameter("no"));

//        MovieDAO.getMovie(request);
//
//        request.setAttribute("content", "jsp/movie/movie_detail.jsp");
//
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    public void destroy() {
    }
}