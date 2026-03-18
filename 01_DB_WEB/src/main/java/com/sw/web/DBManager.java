package com.sw.web;

import java.sql.*;

public class DBManager {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@10.1.82.127:1521:XE";
        String user = "c##sw1004";
        String password = "sw1004";

        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {

            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
