package com.example.demo.dto;

import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.GroupUserEntity;
import com.example.demo.entities.UserEntity;
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
