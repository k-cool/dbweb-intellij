package com.sw.board.main;

import java.sql.*;

public class DBManager {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.p6spy.engine.spy.P6SpyDriver";
        String url = "jdbc:p6spy:oracle:thin:@10.1.82.127:1521:XE";
        String user = "c##sw1004";
        String password = "sw1004";

        Class.forName(driver);

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

            // connection을 재사용 하므로 닫으면 안된다.
            if (con != null) {
                //  con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
