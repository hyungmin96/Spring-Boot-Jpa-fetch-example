package com.example.querydsl.dto;

import com.example.querydsl.entities.UserProfileEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfileDTO {

    private String profilePath;

    public UserProfileEntity toEntity(){
        return UserProfileEntity.builder().profilePath(profilePath).build();
    }

}
