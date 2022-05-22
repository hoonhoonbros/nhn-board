package com.nhnacademy.jdbc.board.domain.page;

public class PageRequest {
    private final int limit;
    private final Long offset;
    private Long numOfPosts;

    public PageRequest(int limit, Long offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public Long getNumOfPosts() {
        return numOfPosts;
    }

    public void setNumOfPosts(Long numOfPosts) {
        this.numOfPosts = numOfPosts;
    }
}
