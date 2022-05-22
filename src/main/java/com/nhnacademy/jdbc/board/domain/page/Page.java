package com.nhnacademy.jdbc.board.domain.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Page {
    private Long pageNo;
    private int perPageCount;

    public void setPageNo(Long pageNo) {
        if (this.pageNo <= 0) {
            this.pageNo = 1L;
            return;
        }
        this.pageNo = pageNo;
    }

    public void setPerPageCount(int perPageCount) {
        this.perPageCount = perPageCount;
    }

    public Long getOffset() {
        return (this.pageNo - 1) * perPageCount;
    }
}
