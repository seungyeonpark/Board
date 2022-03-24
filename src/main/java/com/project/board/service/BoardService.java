package com.project.board.service;

import com.project.board.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> list() throws Exception;
}
