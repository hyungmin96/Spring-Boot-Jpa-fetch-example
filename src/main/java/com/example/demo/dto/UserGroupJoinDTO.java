package com.example.demo.dto;

import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserGroupJoinEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGroupJoinDTO {

    private UserEntity user;
    private GroupEntity group;

    public UserGroupJoinEntity toEntity(){
        return UserGroupJoinEntity.builder()
                .user(user)
                .group(group)
                .build();
    }

}
