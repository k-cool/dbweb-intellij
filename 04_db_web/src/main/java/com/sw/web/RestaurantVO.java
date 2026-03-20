package com.sw.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantVO {
    private int no;
    private String name;
    private String place;
    private String img;
}
