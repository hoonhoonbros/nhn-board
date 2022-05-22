package com.nhnacademy.jdbc.board.domain.post;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long postNo;
    private Long userNo;
    private Long parentPostNo;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private Integer postDepth;
    private Long postGroupNo;
    private Long postGroupSeq;
}
