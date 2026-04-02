package com.sw.board.jquery;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sw.board.main.DBManager;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HumanDAO {
    public static void test1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
    }

    public static void test2(HttpServletRequest request, HttpServletResponse response) {

        String str = "안녕?";

        // json
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("string", str);

        response.setContentType("application/json; charset=UTF-8");

        try {
            response.getWriter().println(jsonObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void test3(HttpServletRequest request, HttpServletResponse response) {

        Human human = new Human();

        human.setName("mz");
        human.setAge(20);

//        JsonObject object = new JsonObject();
//        object.addProperty("name", "mz");
//        object.addProperty("age", 20);


        response.setContentType("application/json; charset=UTF-8");

        try {
            System.out.println(human.toJSON());

            // 1. 객체 응답
//            response.getWriter().println(human.toJSON());

            // 2. 객체 키값 실어서 전송
            JsonObject object = new JsonObject();
            JsonParser parser = new JsonParser();
            object.add("person", parser.parse(human.toJSON()));
            response.getWriter().println(object);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void test4(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json; charset=UTF-8");

        Human human1 = new Human(1, "mz1", 10);
        Human human2 = new Human(2, "mz2", 20);
        Human human3 = new Human(3, "mz3", 30);

        ArrayList<String> people = new ArrayList<>();
        people.add(human1.toJSON());
        people.add(human2.toJSON());
        people.add(human3.toJSON());

        System.out.println(people);

        JsonObject object = new JsonObject();
        JsonParser parser = new JsonParser();
        object.add("people", parser.parse(people.toString()));

        try {
            response.getWriter().println(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void test5(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json; charset=UTF-8");

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM HUMAN_TEST";

        /*
            순회돌때마다 new 하는것보다 한번 new한 객체를 재사용하는 것이
            새로운 메모리 할당을 하지 않으므로 성능상 이점이 있다.
        */
        
        ArrayList<String> people = new ArrayList<>();
        Human human = new Human();

        try {

            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                human.setNo(rs.getInt("h_no"));
                human.setName(rs.getString("h_name"));
                human.setAge(rs.getInt("h_age"));
                people.add(human.toJSON());
            }

            JsonObject object = new JsonObject();
            JsonParser parser = new JsonParser();
            object.add("people", parser.parse(people.toString()));

            response.getWriter().println(object);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

    }
}
