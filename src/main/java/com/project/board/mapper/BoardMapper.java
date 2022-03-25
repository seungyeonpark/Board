package com.project.board.mapper;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    public int count() throws Exception;
    List<Board> list(PageRequest pageRequest) throws Exception;
    void create(Board board) throws Exception;
    Board read(Long boardNo) throws Exception;
    void update(Board board) throws Exception;
    void delete(Long boardNo) throws Exception;
}
