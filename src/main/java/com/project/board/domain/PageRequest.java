package com.project.board.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageRequest {

    private int page;
    private final int boardNumPerPage = 10;

    private String searchType;
    private String keyword;

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

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getStartBoard() {
        return (this.page - 1) * boardNumPerPage;
    }
}
