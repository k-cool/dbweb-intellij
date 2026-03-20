package com.sw.web;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "restarant C", value = "/restaurant")
public class RestaurantC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("restaurants", RestaurantM.getAllRestaurant(M.getRestaurant(request)));

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String saveRealPath = request.getServletContext().getRealPath("/imgs");

        File dir = new File(saveRealPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        MultipartRequest mr = new MultipartRequest(
                request,
                saveRealPath,
                30 * 1024 * 1024,
                "UTF-8",
                new DefaultFileRenamePolicy()
        );

        RestaurantM.addRestaurant(M.getRestaurant(mr));

        response.sendRedirect("restaurant");
    }

    public void destroy() {
    }
}