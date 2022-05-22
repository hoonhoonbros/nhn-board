package com.nhnacademy.jdbc.board.domain.page;

public interface Pageable {
    void paginate();

    PageRequest getPagingPosts();

    void setNumOfPosts(Integer selectNumOfPosts);
}
