package com.project.board.service;

import com.project.board.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> list() throws Exception;
    void register(Board board) throws Exception;
    Board read(Long boardNo) throws Exception;
}
