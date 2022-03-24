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

    @Override
    public Board read(Long boardNo) throws Exception {
        return mapper.read(boardNo);
    }

    @Override
    public void modify(Board board) throws Exception {
        mapper.update(board);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        mapper.delete(boardNo);
    }
}
