package com.sw.web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home controller", value = "/main")
public class HomeC extends HttpServlet {
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setCharacterEncoding("utf-8");
//
//        request.setAttribute("memberList", MemberDAO.getAllMember());
//
//        request.getRequestDispatcher("member_list.jsp").forward(request, response);
//    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setCharacterEncoding("utf-8");
//
//        MemberDAO.addMember(request);
//
//        response.sendRedirect("main");
//    }


    public void destroy() {
    }
}