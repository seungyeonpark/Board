package com.project.board.service;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;
import com.project.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    @Override
    public Integer count(PageRequest pageRequest) throws Exception {
        return mapper.count(pageRequest);
    }

    @Override
    public List<Board> list(PageRequest pageRequest) throws Exception {
        return mapper.list(pageRequest);
    }

    @Override
    public void register(Board board, MultipartFile file) throws Exception {

        setFileNameAndPath(board, file);
        mapper.create(board);
    }

    @Override
    public Board read(Long boardNo) throws Exception {
        return mapper.read(boardNo);
    }

    @Override
    public void modify(Board board, MultipartFile file) throws Exception {

        removeExistingFile(board.getFilename());

        setFileNameAndPath(board, file);

        mapper.update(board);
    }

    @Override
    public void remove(Long boardNo) throws Exception {

        Board board = mapper.read(boardNo);

        removeExistingFile(board.getFilename());

        mapper.delete(boardNo);
    }

    private void removeExistingFile(String fileName) {
        File file = new File(getFilePath() + "\\" + fileName);

        if (file.exists()) {
            file.delete();
        }
    }

    private void setFileNameAndPath(Board board, MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return;
        }

        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + file.getOriginalFilename();

        File savedFile = new File(getFilePath(), filename);

        file.transferTo(savedFile);

        board.setFilename(filename);
        board.setFilepath("/files/" + filename);
    }

    private String getFilePath() {
        return System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
    }
}
