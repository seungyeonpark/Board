package com.project.board.mapper;

import com.project.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    void create(Member member) throws Exception;
    Member login(Member member) throws Exception;
}
