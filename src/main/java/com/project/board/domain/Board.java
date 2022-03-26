package com.project.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Board {

    private Long boardNo;

    @NotBlank
    private String title;

    @NotBlank
    private String writer;

    private String content;

    private String filename;
    private String filepath;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;
}
