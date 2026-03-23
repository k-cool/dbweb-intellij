package com.sw.board.movie;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sw.board.main.DBManager;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
   Singleton 방식
   - 클래스의 객체를 딱 1개마만 만들어서 사용하는 패턴
   - 인스턴스를 내부변수에 담아서 상수화 시킨다. -> static final
   - 새로운 인스턴스 생성을 방지하기 위해 기본 생성자 함수의 접근을 막는다. -> private 기본생성자함수
*/

public class MovieDAO {
    public static final MovieDAO movieDAO = new MovieDAO();

    // singleton을 만들어주기 위해 기본생성자를 private로 잠근다!
    private MovieDAO() {
    }

    private ArrayList<MovieDTO> movies;

    public void selectAllMovie(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM MOVIE_TEST";

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            movies = new ArrayList<>();

            while (rs.next()) {
                movies.add(new MovieDTO(
                        rs.getInt("m_no"),
                        rs.getString("m_title"),
                        rs.getString("m_actor"),
                        rs.getString("m_img"),
                        rs.getString("m_story")
                ));
            }

            request.setAttribute("movies", movies);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
    }

    public void addMovie(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO MOVIE_TEST VALUES (MOVIE_TEST_SEQ.NEXTVAL, ?, ?, ?, ?)";

//        String saveRealPath = request.getServletContext().getRealPath("movieFile");
        String saveRealPath = "C:\\Users\\soldesk\\Desktop\\sw\\upload\\movieFile";

        //        File dir = new File(saveRealPath);
        //
        //        if (!dir.exists()) {
        //            dir.mkdirs();
        //        }


        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            MultipartRequest mr = new MultipartRequest(
                    request,
                    saveRealPath,
                    30 * 1024 * 1024,
                    "UTF-8",
                    new DefaultFileRenamePolicy()
            );

            String title = mr.getParameter("title");
            String actor = mr.getParameter("actor");
            String story = mr.getParameter("story");
            String file = mr.getFilesystemName("file");

            System.out.println(title);
            System.out.println(actor);
            System.out.println(story);
            System.out.println(file);

            // 입력 값 중에서 개행을 <br>로 치환
            story = story.replaceAll("\r\n", "<br>");

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, file);
            pstmt.setString(4, story);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("INSERT SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void deleteMovie(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE MOVIE_TEST WHERE M_NO = ?";

        int no = Integer.parseInt(request.getParameter("no"));

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, no);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("DELETE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void getMovie(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM MOVIE_TEST WHERE M_NO = ?";
        String no = request.getParameter("no");

        if (no == null) {
            no = (String) request.getAttribute("no");
        }

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, no);

            rs = pstmt.executeQuery();

            MovieDTO movie = null;

            if (rs.next()) {
                movie = new MovieDTO(
                        rs.getInt("m_no"),
                        rs.getString("m_title"),
                        rs.getString("m_actor"),
                        rs.getString("m_img"),
                        rs.getString("m_story")
                );
            }

            request.setAttribute("movie", movie);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
    }

    public void updateMovie(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE MOVIE_TEST SET M_TITLE = ?, M_ACTOR = ?, M_STORY = ? WHERE M_NO = ?";

        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String story = request.getParameter("story");
        int no = Integer.parseInt(request.getParameter("no"));

        // 입력 값 중에서 개행을 <br>로 치환
        story = story.replaceAll("\r\n", "<br>");

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, story);
            pstmt.setInt(4, no);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("UPDATE SUCCESS");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void updateMovie2(HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE MOVIE_TEST SET M_TITLE = ?, M_ACTOR = ?, M_STORY = ?, M_IMG = ? WHERE M_NO = ?";

        String saveRealPath = "C:\\Users\\soldesk\\Desktop\\sw\\upload\\movieFile";

        try {
            conn = DBManager.getConnection();

            pstmt = conn.prepareStatement(sql);

            MultipartRequest mr = new MultipartRequest(
                    request,
                    saveRealPath,
                    30 * 1024 * 1024,
                    "UTF-8",
                    new DefaultFileRenamePolicy()
            );

            String title = mr.getParameter("title");
            String actor = mr.getParameter("actor");
            String story = mr.getParameter("story");
            String newImg = mr.getFilesystemName("newImg");
            String oldImg = mr.getParameter("oldImg");
            String img = newImg == null ? oldImg : newImg;
            int no = Integer.parseInt(mr.getParameter("no"));


            System.out.println(newImg);
            System.out.println(oldImg);
            System.out.println(img);
            request.setAttribute("no", no);

            System.out.println(title);
            System.out.println(actor);
            System.out.println(story);
            System.out.println(img);
            System.out.println(no);

            // 입력 값 중에서 개행을 <br>로 치환
            story = story.replaceAll("\r\n", "<br>");

            pstmt.setString(1, title);
            pstmt.setString(2, actor);
            pstmt.setString(3, story);
            pstmt.setString(4, img);
            pstmt.setInt(5, no);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("UPDATE SUCCESS");

                if (img != null) {
                    File f = new File(saveRealPath + "/" + oldImg);
                    f.delete();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, null);
        }
    }

    public void paging(int pageNum, HttpServletRequest request) {
        request.setAttribute("currentPage", pageNum);

        int total = movies.size();
        int cnt = 3;

        // 페이지수
        int totalPage = (int) Math.ceil((double) total / cnt);
        int start = total - (cnt * (pageNum - 1));
        int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

        ArrayList<MovieDTO> items = new ArrayList<MovieDTO>();

        for (int i = start - 1; i > end; i--) {
            items.add(movies.get(i));
        }


        request.setAttribute("totalPage", totalPage);
        request.setAttribute("movies", items);

    }
}
