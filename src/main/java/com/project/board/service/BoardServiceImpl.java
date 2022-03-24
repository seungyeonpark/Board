package com.project.board.service;

import com.project.board.domain.Board;
import com.project.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    @Override
    public List<Board> list() throws Exception {
        return mapper.list();
    }

    @Override
    public void register(Board board) throws Exception {
        mapper.create(board);
    }
}
