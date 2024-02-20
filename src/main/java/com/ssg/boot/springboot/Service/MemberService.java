package com.ssg.boot.springboot.Service;

import com.ssg.boot.springboot.dao.MemberDao;
import com.ssg.boot.springboot.dto.MemberDto;
import com.ssg.boot.springboot.dto.MemberReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public List<MemberDto> allMember() {
        return memberDao.allMember();
    }

    public void insertMember(MemberDto dto) {
        memberDao.insertMember(dto);
    }

    public MemberDto login(MemberReqDto dto) {
        return memberDao.login(dto);
    }

    public Boolean idCheck(String id) {
        return memberDao.idCheck(id) <= 0;
    }
}
