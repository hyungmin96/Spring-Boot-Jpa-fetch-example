package com.example.demo.dto;

import com.example.demo.entities.GroupEntity;
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
