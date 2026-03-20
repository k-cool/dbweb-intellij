package com.sw.web;

import javax.servlet.http.HttpServletRequest;

public class M {
    // 파라미터 값으로 member 객체를 생성해주는 기능
    public static MemberDTO getMember(HttpServletRequest req) {
        String no = req.getParameter("no");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        int checkedNo = 0;
        int checkedAge = 0;

        if (no != null) {
            checkedNo = Integer.parseInt(no);
        }

        if (age != null) {
            checkedAge = Integer.parseInt(age);
        }

        return new MemberDTO(checkedNo, name, checkedAge);
    }
}
