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
public class Member {

    private int userNo;

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;
}
