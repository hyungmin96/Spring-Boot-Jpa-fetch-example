package com.example.querydsl.dto;

import com.example.querydsl.entities.GroupBoardEntity;
import com.example.querydsl.entities.GroupEntity;
import com.example.querydsl.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupBoardDTO {

    private String title;
    private String content;
    private Long group_id;
    private Long user_id;

    private UserEntity user;
    private GroupEntity group;

    public GroupBoardEntity toEntity(){
        return GroupBoardEntity.builder()
                .title(title)
                .user(user)
                .group(group)
                .content(content)
                .build();
    }

}
