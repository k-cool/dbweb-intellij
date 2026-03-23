package com.sw.board.movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "movie", value = "/movie")
public class MovieC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int p = 1;

        if (request.getParameter("p") != null) {
            p = Integer.parseInt(request.getParameter("p"));
        }

        MovieDAO.movieDAO.selectAllMovie(request);

        MovieDAO.movieDAO.paging(p, request);

        request.setAttribute("content", "jsp/movie/movie.jsp");

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