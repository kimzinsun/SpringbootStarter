package com.ssg.boot.springboot.controller;

import com.ssg.boot.springboot.Service.MemberService;
import com.ssg.boot.springboot.dto.MemberDto;
import com.ssg.boot.springboot.dto.MemberReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("allmember")
    public List<MemberDto> allMember() {
        return memberService.allMember();
    }

    @PostMapping("insertmember")
    public String insertMember(@RequestBody MemberDto dto) {
        memberService.insertMember(dto);
        return "success";
    }

    @PostMapping("login")
    public ResponseEntity<MemberDto> login(@RequestBody MemberReqDto dto) {
        if (memberService.login(dto) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(memberService.login(dto));
        }
    }

    @GetMapping("idcheck")
    public ResponseEntity<Boolean> idCheck(String id) {
        
        if (memberService.idCheck(id)) {
            return ResponseEntity.ok(memberService.idCheck(id));

        } else {
            return ResponseEntity.ok(memberService.idCheck(id));
        }
    }
}
