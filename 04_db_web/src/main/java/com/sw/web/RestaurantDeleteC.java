package com.sw.web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "restarant delete C", value = "/restaurant/delete")
public class RestaurantDeleteC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("restaurants", RestaurantM.getAllRestaurant(M.getRestaurant(request)));

//        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RestaurantM.deleteRestaruant(M.getRestaurant(request));
    }

    public void destroy() {
    }
}