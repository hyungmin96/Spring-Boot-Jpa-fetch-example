package com.example.demo.dto;

import com.example.demo.entities.GroupBoardCommentEntity;
import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupCommentDTO {

    private String comment;
    private Long board_id;
    private Long user_id;

    private UserEntity user;
    private GroupBoardEntity board;

    public GroupBoardCommentEntity toEntity(){
        return GroupBoardCommentEntity.builder()
                .comment(comment)
                .board(board)
                .user(user)
                .build();
    }

}
