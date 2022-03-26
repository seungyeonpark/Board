package com.project.board.service;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    Integer count() throws Exception;
    List<Board> list(PageRequest pageRequest) throws Exception;
    void register(Board board, MultipartFile file) throws Exception;
    Board read(Long boardNo) throws Exception;
    void modify(Long boardNo, MultipartFile file) throws Exception;
    void remove(Long boardNo) throws Exception;
}
