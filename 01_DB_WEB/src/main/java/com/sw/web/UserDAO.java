package com.sw.web;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    public static void showAllPeople(HttpServletRequest request) throws ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM NAME_AGE_TEST";


        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DBManager.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            ArrayList<Human> humans = new ArrayList<>();

            while (rs.next()) {
                humans.add(new Human(
                        rs.getString("n_name"),
                        rs.getInt("n_age")
                ));
            }

            request.setAttribute("userList", humans);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, ps, rs);
        }


//        try (
//                Connection con = DriverManager.getConnection(url, user, password);
//                PreparedStatement ps = con.prepareStatement(sql);
//                ResultSet rs = ps.executeQuery();
//        ) {
//            while (rs.next()) {
//                String name = rs.getString("n_name");
//                String age = rs.getString("n_age");
//
//                System.out.println(name + " " + age);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
