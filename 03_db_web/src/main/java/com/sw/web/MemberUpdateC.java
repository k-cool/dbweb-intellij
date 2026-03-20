package com.sw.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "member update controller", value = "/member/update")
public class MemberUpdateC extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("POST /member/update");

        request.setCharacterEncoding("utf-8");

        MemberDAO.updateMemberName(M.getMember(request));
    }


    public void destroy() {
    }
}