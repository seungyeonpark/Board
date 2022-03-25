package com.project.board.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pagination {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayListNum = 10;

    private PageRequest pageRequest;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    private void calcData() {
        endPage = (int)(Math.ceil(pageRequest.getPage() / (double)displayListNum) * displayListNum);
        startPage = (endPage - displayListNum) + 1;

        int lastPage = (int)(Math.ceil(totalCount / (double)pageRequest.getBoardNumPerPage()));

        if (endPage > lastPage) {
            endPage = lastPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * pageRequest.getBoardNumPerPage() >= totalCount ? false : true;
    }
}
