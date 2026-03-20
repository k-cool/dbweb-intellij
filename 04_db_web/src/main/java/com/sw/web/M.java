package com.sw.web;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.http.HttpServletRequest;

public class M {

    static public RestaurantVO getRestaurant(HttpServletRequest request) {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String img = request.getParameter("img");
        int intNo = 0;

        if (no != null) {
            intNo = Integer.parseInt(no);
        }

        return new RestaurantVO(intNo, name, place, img);
    }

    static public RestaurantVO getRestaurant(MultipartRequest request) {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String img = request.getFilesystemName("img");

        int intNo = 0;

        if (no != null) {
            intNo = Integer.parseInt(no);
        }

        if (img == null) {
            img = "default.webp";
        }
        
        return new RestaurantVO(intNo, name, place, img);
    }
}
