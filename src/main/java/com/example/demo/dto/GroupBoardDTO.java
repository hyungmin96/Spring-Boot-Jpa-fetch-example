package com.example.demo.dto;

import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
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
