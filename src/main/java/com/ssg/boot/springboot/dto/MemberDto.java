package com.ssg.boot.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String id;
    private String password;
    private String name;
    private String email;
    private int auth;
}


