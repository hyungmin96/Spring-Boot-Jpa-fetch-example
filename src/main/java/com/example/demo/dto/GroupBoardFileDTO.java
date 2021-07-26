package com.example.demo.dto;

import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupBoardFileEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupBoardFileDTO {

    private String file_name;
    private String file_path;
    private Long board_id;

    private GroupBoardEntity boardEntity;

    public GroupBoardFileEntity toEntity(){
        return GroupBoardFileEntity.builder()
                .name(file_name)
                .path(file_path)
                .board(boardEntity)
                .build();
    }

}
