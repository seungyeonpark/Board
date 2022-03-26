package com.project.board.service;

import com.project.board.domain.Member;

public interface MemberService {

    void register(Member member) throws Exception;
    Member login(Member member) throws Exception;
}
