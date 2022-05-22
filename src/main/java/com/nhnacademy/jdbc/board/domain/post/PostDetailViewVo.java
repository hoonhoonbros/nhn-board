package com.nhnacademy.jdbc.board.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailViewVo {
    private Long postNo;
    private String title;
    private String username;
    private String content;
}
