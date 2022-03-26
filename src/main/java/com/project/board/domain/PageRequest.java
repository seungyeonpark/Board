package com.project.board.domain;

import lombok.ToString;

@ToString
public class PageRequest {

    private int page;
    private final int boardNumPerPage = 10;

    public PageRequest() {
        this.page = 1;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public int getStartBoard() {
        return (this.page - 1) * boardNumPerPage;
    }

    public int getBoardNumPerPage() {
        return this.boardNumPerPage;
    }
}
