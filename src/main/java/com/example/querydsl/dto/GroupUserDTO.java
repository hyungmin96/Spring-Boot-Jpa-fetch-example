package com.example.querydsl.dto;

import com.example.querydsl.entities.GroupEntity;
import com.example.querydsl.entities.GroupUserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupUserDTO {

    private Long userId;
    private GroupEntity group;

    public GroupUserEntity toEntity(){
        return GroupUserEntity.builder()
                .userId(userId)
                .group(group)
                .build();
    }

}
