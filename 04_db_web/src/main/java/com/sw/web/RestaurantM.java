package com.sw.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RestaurantM {
    public static ArrayList<RestaurantVO> getAllRestaurant(RestaurantVO restaurant) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM restaurant_test ORDER BY r_no";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<RestaurantVO> restaurants = new ArrayList<>();

            while (rs.next()) {
                restaurants.add(new RestaurantVO(
                        rs.getInt("r_no"),
                        rs.getString("r_name"),
                        rs.getString("r_place"),
                        rs.getString("r_img")
                ));
            }

            return restaurants;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return null;

    }

    public static void addRestaurant(RestaurantVO restaurant) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO restaurant_test VALUES (restaurant_test_seq.nextval, ?, ?, ?)";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getPlace());
            pstmt.setString(3, restaurant.getImg());

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

    public static void deleteRestaruant(RestaurantVO restaurant) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM restaurant_test WHERE r_no = ?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, restaurant.getNo());

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

    public static void updateRestaurantName(RestaurantVO restaurant) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "UPDATE restaurant_test SET r_name = ? WHERE r_no = ?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, restaurant.getName());
            pstmt.setInt(2, restaurant.getNo());

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
