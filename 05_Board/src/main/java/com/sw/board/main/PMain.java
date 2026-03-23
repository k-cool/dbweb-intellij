package com.sw.board.main;

import com.sw.board.movie.MovieDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PMain {

    public static void main(String[] args) {
        System.out.println(11);

        // 규칙
        int 총데이터수 = 11;
        int 한페이지당보여줄개수 = 3;

        // 페이지수
        int 총페이지수 = (int) Math.ceil((double) 총데이터수 / 한페이지당보여줄개수);
        System.out.println(총페이지수);

        // 페이지 번호
        int 페이지번호 = 2;

        /*
            1p: 1, 2, 3
            2p: 4, 5, 6
            3p: 7, 8, 9
            4p: 10, 11
        */

        int 시작데이터번호 = (페이지번호 - 1) * 한페이지당보여줄개수 + 1;
        int 끝데이터번호 = (페이지번호 == 총페이지수) ? 총데이터수 : 시작데이터번호 + 한페이지당보여줄개수 - 1;

        /*
            1p: 11, 10, 9
            2p: 8, 7, 6
            3p: 5, 4, 3
            4p: 2, 1
        */

        int 시작데이터번호2 = 총데이터수 - (한페이지당보여줄개수 * (페이지번호 - 1));
        int 끝데이터번호2 = (페이지번호 == 총페이지수) ? -1 : 시작데이터번호2 - (한페이지당보여줄개수 + 1);


    }

    public static void paging(int pageNum, HttpServletRequest request) {

        int total = 11;
        int cnt = 3;

        // 페이지수
        int totalPage = (int) Math.ceil((double) total / cnt);
        int start = total - (cnt * (pageNum - 1));
        int end = (pageNum == totalPage) ? -1 : start - (cnt + 1);

        ArrayList<MovieDTO> items = new ArrayList<MovieDTO>();

        for (int i = start - 1; i > end; i--) {
//            items.add(movies.get(i));
        }
    }
}
