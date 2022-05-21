package com.nhnacademy.jdbc.board.domain.post;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostViewVo {
    private Long postNo;
    private String title;
    private String username;
    private Date createdAt;
}
