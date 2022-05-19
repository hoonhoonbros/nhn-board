package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectPosts();
}
