package com.ssg.boot.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PdsDto {
    private String id;
    private String title;
    private String contents;
}
