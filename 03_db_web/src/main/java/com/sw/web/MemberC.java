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

        request.setAttribute("memberList", MemberDAO.getAllMember());

        request.getRequestDispatcher("member_list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("POST /member");

        request.setCharacterEncoding("utf-8");

        MemberDAO.addMember(M.getMember(request));

        response.sendRedirect("member");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("DELETE /member");

        MemberDAO.deleteMemeber(M.getMember(request));
    }


    public void destroy() {
    }
}