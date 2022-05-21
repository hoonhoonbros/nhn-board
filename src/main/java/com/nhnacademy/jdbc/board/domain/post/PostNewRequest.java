package com.nhnacademy.jdbc.board.domain.post;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class PostNewRequest {
    private final Long userNo;
    private final Long parentPostNo;
    private final String title;
    private final String content;
    private final Date createdAt;
    private final Integer postDepth;
    private final Integer sequenceNo;
}
