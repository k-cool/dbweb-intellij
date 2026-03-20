package com.sw.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
    public static ArrayList<MemberDTO> getAllMember() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM MEMBER_TEST ORDER BY M_NO DESC";

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            ArrayList<MemberDTO> memberList = new ArrayList<>();

            while (rs.next()) {
                memberList.add(new MemberDTO(
                        rs.getInt("m_no"),
                        rs.getString("m_name"),
                        rs.getInt("m_age")
                ));
            }

            return memberList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return null;
    }

    public static void addMember(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO MEMBER_TEST VALUES (MEMBER_TEST_SEQ.NEXTVAL, ?, ?)";

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, age);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("INSERT SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public static void deleteMemeber(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE MEMBER_TEST WHERE M_NO = ?";

        int no = Integer.parseInt(request.getParameter("no"));

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, no);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("DELETE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public static void updateMemberName(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE MEMBER_TEST SET M_NAME = ? WHERE M_NO = ?";

        int no = Integer.parseInt(request.getParameter("no"));
        String name = request.getParameter("name");

        System.out.println(name);

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setInt(2, no);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("UPDATE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }
}
