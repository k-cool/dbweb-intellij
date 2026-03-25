package com.sw.board.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountVO {
    private String id;
    private String pw;
    private String name;
}
