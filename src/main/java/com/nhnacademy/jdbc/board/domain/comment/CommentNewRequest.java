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
public class CommentNewRequest {
    private Long userNo;
    private Long postNo;
    private Long commentNo;
    private String author;
    private String content;
    private Date createdAt;
}
