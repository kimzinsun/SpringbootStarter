package com.ssg.boot.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberReqDto {
    private String id;
    private String password;
}
