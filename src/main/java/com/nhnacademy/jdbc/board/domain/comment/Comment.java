package com.nhnacademy.jdbc.board.domain.comment;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long commentNo;
    private Long userNo;
    private Long postNo;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
