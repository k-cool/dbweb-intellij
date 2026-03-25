package com.sw.board.account;

import com.sw.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    public static final AccountDAO ACCOUNT_DAO = new AccountDAO();

    private AccountDAO() {
    }


    public boolean loginCheck(HttpServletRequest request) {
        AccountVO user = (AccountVO) request.getSession().getAttribute("user");

        if (user != null) {
            request.setAttribute("loginPage", "jsp/account/login_ok.jsp");
            return true;
        } else {
            request.setAttribute("loginPage", "jsp/account/login.jsp");
            return false;
        }
    }

    public void login(HttpServletRequest request) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM LOGIN_TEST WHERE l_id = ?";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            String msg = null;

            if (rs.next()) {
                if (rs.getString("l_pw").equals(pw)) {
                    // 로그인 성공
                    msg = "로그인 성공";

                    AccountVO accountVO = new AccountVO(
                            rs.getString("l_id"),
                            rs.getString("l_pw"),
                            rs.getString("l_name")
                    );


                    HttpSession hs = request.getSession();

                    hs.setMaxInactiveInterval(60 * 10); // default -> 30분
//                    hs.setMaxInactiveInterval(5); // default -> 30분
                    hs.setAttribute("user", accountVO);
//                    request.setAttribute("user", accountVO);

                } else {
                    // 비밀번호 불일치
                    msg = "비밀번호 불일치";
                }
            } else {
                // 유저 없음
                msg = "유저 없음";
            }

            System.out.println(msg);

            request.setAttribute("msg", msg);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
//        request.getSession().setAttribute("user", null);

//        request.getSession().invalidate();
//        -> 세션내에 다른 정보를 의도치 않게 삭제 시킬 수 있으므로 사용시 조심

    }

    public boolean deleteUser(HttpServletRequest request) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE LOGIN_TEST WHERE l_id = ?";

        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        String userId = user.getId();
        String userPw = user.getPw();
        String pw = request.getParameter("pw");


        try {
            if (!userPw.equals(pw)) return false;

            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userId);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("DELETE SUCCESS");

                logout(request);

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }

        return false;
    }

    public void editUser(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE LOGIN_TEST SET l_pw = ?, l_name = ? WHERE l_id = ?";

        AccountVO user = (AccountVO) request.getSession().getAttribute("user");
        String userId = user.getId();
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");

        System.out.println(userId);
        System.out.println(pw);
        System.out.println(name);

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pw);
            pstmt.setString(2, name);
            pstmt.setString(3, userId);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("UPDATE SUCCESS");

                // 세션 업데이트
                user.setPw(pw);
                user.setName(name);

                request.getSession().setAttribute("user", user);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }

    }
}
