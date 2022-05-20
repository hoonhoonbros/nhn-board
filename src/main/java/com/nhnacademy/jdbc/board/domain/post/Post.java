package com.nhnacademy.jdbc.board.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private final Long postNo;
    private final Long userNo;
    private final String title;
    private final String content;
    private final Date createdAt;
    private final Date updatedAt;
    private final Date deletedAt;
    private final Long parentPostNo;
    private final Integer postDepth;
}
