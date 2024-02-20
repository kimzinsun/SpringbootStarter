package com.ssg.boot.springboot.controller;

import com.ssg.boot.springboot.dto.HumanDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        
        return "Hello, Spring Boot!";
    }

    @GetMapping("test")
    public int test() {
        
        return 100;
    }

    @GetMapping("/human")
    public HumanDto human() {
        
        HumanDto dto = new HumanDto("abc", "김진선", 168.0);
        return dto;
    }

    @GetMapping("conn_param")
    public String conn_param(String id, String name) {
        
        
        return "success";
    }

    @GetMapping("param_obj")
    public String param_obj(HumanDto dto) {
        
        
        return "success";

    }

    @GetMapping("getlist")
    public List<HumanDto> getlist() {
        
        List<HumanDto> list = new ArrayList<HumanDto>();
        list.add(new HumanDto("a", "김진선", 168.0));
        list.add(new HumanDto("b", "한다운", 190.0));
        list.add(new HumanDto("c", "사랑해", 999.9));

        return list;
    }

    @GetMapping("getmap")
    public Map<String, Object> getmap() {
        
        String title = "다우니 사랑해";
        List<HumanDto> list = new ArrayList<HumanDto>();
        list.add(new HumanDto("a", "김진선", 168.0));
        list.add(new HumanDto("b", "한다운", 190.0));
        list.add(new HumanDto("c", "사랑해", 999.9));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("list", list);

        return map;
    }

}
