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
public class PostItem {
    private Long postNo;
    private String title;
    private String username;
    private String author;
    private String modifier;
    private Date createdAt;
    private Integer replyCount;
}
