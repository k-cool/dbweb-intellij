package com.sw.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "member controller", value = "/member")
public class MemberC extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("GET /member");
        request.setCharacterEncoding("utf-8");

        request.setAttribute("memberList", MemberDAO.getAllMember());

        request.getRequestDispatcher("member_list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("POST /member");

        request.setCharacterEncoding("utf-8");

        MemberDAO.addMember(request);

        response.sendRedirect("member");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("PUT /member");

        request.setCharacterEncoding("utf-8");

        MemberDAO.updateMemberName(request);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("DELETE /member");

        request.setCharacterEncoding("utf-8");

        MemberDAO.deleteMemeber(request);
    }


    public void destroy() {
    }
}