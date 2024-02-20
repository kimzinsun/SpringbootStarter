package com.ssg.boot.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HumanDto {
    private String id;
    private String name;
    private double height;


    public String toString() {
        return "id: " + id + ", name: " + name + ", height: " + height;
    }
}

