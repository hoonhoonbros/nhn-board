package com.nhnacademy.jdbc.board.domain.page;

import static java.lang.Math.ceil;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySqlPaginator implements Pageable {
    private int numOfPosts;
    private Long endPage;
    private Long startPage;
    private Long offset;

    private boolean prev;
    private boolean next;

    private Page page;

    public MySqlPaginator(Integer numOfPosts, Page page) {
        this.numOfPosts = numOfPosts;
        this.page = page;

        this.paginate();
    }

    private void calcEndPage() {
        this.endPage = (long) ceil((double) this.numOfPosts / this.page.getPerPageCount());
    }

    private void calcStartPage() {
        // this.startPage = this.endPage / (long) this.page.getPageNo();
        if (this.endPage == 0) {
            this.startPage = 1L;
        } else {
            this.startPage = (this.endPage - this.page.getPerPageCount()) + 1;
        }
    }

    public Long getOffset() {
        return (this.page.getPageNo() - 1) * this.page.getPerPageCount();
    }

    public int getLimit() {
        return this.page.getPerPageCount();
    }

    @Override
    public void paginate() {
        this.calcEndPage();
        this.calcStartPage();

        this.prev = this.page.getPageNo() > 1L;
        this.next = !Objects.equals(this.page.getPageNo(), this.endPage);
    }

    @Override
    public PageRequest getPagingPosts() {
        return new PageRequest(this.page.getPerPageCount(), this.startPage);
    }

    @Override
    public void setNumOfPosts(Integer numOfPosts) {
        this.numOfPosts = numOfPosts;
    }
}
