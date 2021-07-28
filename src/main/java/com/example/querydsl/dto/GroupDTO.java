package com.example.querydsl.dto;

import com.example.querydsl.entities.GroupEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupDTO {

    private String title;

    public GroupEntity toEntity(){
        return GroupEntity.builder()
                .groupTitle(title)
                .build();
    }

}
