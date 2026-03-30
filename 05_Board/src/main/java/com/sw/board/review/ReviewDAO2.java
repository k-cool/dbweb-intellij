package com.sw.board.review;

import com.sw.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReviewDAO2 {
    public static final ReviewDAO2 REVIEW_DAO = new ReviewDAO2();

    private ReviewDAO2() {
    }

    public static void deleteReview(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE REVIEW_TEST WHERE R_NO = ?";

        int no = Integer.parseInt(request.getParameter("no"));

        try {
            con = DBManager.getConnection();

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, no);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("DELETE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }

    public ArrayList<ReviewVO> showAllReview(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM REVIEW_TEST ORDER BY R_DATE, R_NO";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<ReviewVO> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new ReviewVO(
                        rs.getInt("r_no"),
                        rs.getString("r_title"),
                        rs.getString("r_txt"),
                        rs.getDate("r_date")
                ));
            }

//            request.setAttribute("reviews", list);

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return null;
    }

    public void addReview(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO REVIEW_TEST VALUES (REVIEW_TEST_SEQ.NEXTVAL, ?, ?, SYSDATE)";

        String title = request.getParameter("title");
        String txt = request.getParameter("txt");

        // 입력 값 중에서 개행을 <br>로 치환
        txt = txt.replaceAll("\r\n", "<br>");

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);


            System.out.println(title);
            System.out.println(txt);

            pstmt.setString(1, title);
            pstmt.setString(2, txt);


            if (pstmt.executeUpdate() > 0) {
                System.out.println("INSERT SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void getReview(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM REVIEW_TEST WHERE R_NO = ?";

        int no = Integer.parseInt(request.getParameter("no"));

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();

            ReviewVO review = null;

            while (rs.next()) {
                review = new ReviewVO(
                        rs.getInt("r_no"),
                        rs.getString("r_title"),
                        rs.getString("r_txt"),
                        rs.getDate("r_date")
                );
            }

            request.setAttribute("review", review);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    public void updateReview(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE REVIEW_TEST SET r_title = ?, r_txt = ? WHERE r_no = ?";

        String no = request.getParameter("no");
        String title = request.getParameter("title");
        String txt = request.getParameter("txt");

        // 입력 값 중에서 개행을 <br>로 치환
        txt = txt.replaceAll("\r\n", "<br>");

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            System.out.println(no);
            System.out.println(title);
            System.out.println(txt);

            pstmt.setString(1, title);
            pstmt.setString(2, txt);
            pstmt.setInt(3, Integer.parseInt(no));

            if (pstmt.executeUpdate() > 0) {
                System.out.println("UPDATE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void paging(int pageNum, HttpServletRequest request) {
        request.setAttribute("currentPage", pageNum);

        ArrayList<ReviewVO> reviews = showAllReview(request);
        int total = reviews.size();
        int cnt = 3;

        // 페이지수
        int totalPage = (int) Math.ceil((double) total / cnt);
        int start = total - (cnt * (pageNum - 1));
        int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

        ArrayList<ReviewVO> items = new ArrayList<>();

        for (int i = start - 1; i > end; i--) {
            items.add(reviews.get(i));
        }


        request.setAttribute("totalPage", totalPage);
        request.setAttribute("reviews", items);

    }
}
