package com.sw.board.review;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReviewVO {
    private int no;
    private String title;
    private String txt;
    private Date date;
}
