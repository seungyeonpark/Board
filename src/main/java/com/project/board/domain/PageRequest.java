package com.project.board.domain;

import lombok.ToString;

@ToString
public class PageRequest {

    private int page;
    private int boardNumPerPage;

    public PageRequest() {
        this.page = 1;
        this.boardNumPerPage = 10;
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

    public int getPageStart() {
        return (this.page - 1) * boardNumPerPage; // 한 페이지 내에서 시작 글
    }

    public int getBoardNumPerPage() {
        return this.boardNumPerPage;
    }
}
