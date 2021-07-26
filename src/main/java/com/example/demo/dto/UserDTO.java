package com.example.demo.dto;

import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserProfileEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

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
