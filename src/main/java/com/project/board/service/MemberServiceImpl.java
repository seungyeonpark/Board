package com.project.board.service;

import com.project.board.domain.Member;
import com.project.board.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;

    @Override
    public void register(Member member) throws Exception{
        mapper.create(member);
    }
}
