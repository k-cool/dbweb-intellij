package com.sw.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO {
    private int no;
    private String name;
    private int age;
}
