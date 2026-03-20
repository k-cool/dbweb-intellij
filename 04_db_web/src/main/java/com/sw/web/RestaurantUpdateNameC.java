package com.sw.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "restarant update C", value = "/restaurant/update/name")
public class RestaurantUpdateNameC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("restaurants", RestaurantM.getAllRestaurant(M.getRestaurant(request)));

//        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RestaurantM.updateRestaurantName(M.getRestaurant(request));
    }

    public void destroy() {
    }
}