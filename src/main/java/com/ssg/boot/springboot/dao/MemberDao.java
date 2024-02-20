package com.ssg.boot.springboot.dao;

import com.ssg.boot.springboot.dto.MemberDto;
import com.ssg.boot.springboot.dto.MemberReqDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberDao {
    List<MemberDto> allMember();

    void insertMember(MemberDto dto);

    MemberDto login(MemberReqDto dto);

    int idCheck(String id);


}
