package com.project.board.service;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;

import java.util.List;

public interface BoardService {
    public int count() throws Exception;
    List<Board> list(PageRequest pageRequest) throws Exception;
    void register(Board board) throws Exception;
    Board read(Long boardNo) throws Exception;
    void modify(Board board) throws Exception;
    void remove(Long boardNo) throws Exception;
}
