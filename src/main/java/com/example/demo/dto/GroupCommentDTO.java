package com.example.demo.dto;

import com.example.demo.entities.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupCommentDTO {

    private String comment;
    private Long board_id;
    private Long user_id;

    private UserEntity user;
    private GroupEntity group;

    public GroupBoardCommentEntity toEntity(){
        return GroupBoardCommentEntity.builder()
                .comment(comment)
                .group(group)
                .comment(comment)
                .build();
    }

}
