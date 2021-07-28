package com.example.querydsl.dto;

import com.example.querydsl.entities.UserEntity;
import com.example.querydsl.entities.UserProfileEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    private Long id;
    private String username;
    private String password;

    private UserProfileEntity profile;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .username(username)
                .password(password)
                .profile(profile)
                .build();
    }

}
