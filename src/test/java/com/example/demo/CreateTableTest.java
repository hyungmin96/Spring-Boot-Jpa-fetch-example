package com.example.demo;

import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.ProfileDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserGroupJoinDTO;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserProfileEntity;
import com.example.demo.repositories.GroupRepository;
import com.example.demo.repositories.UserGroupJoinRepository;
import com.example.demo.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.yml")
public class CreateTableTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserGroupJoinRepository userGroupJoinRepository;

    @Test
    void 유저_와_프로필_생성(){

        userRepository.deleteAll();

        for(int i = 1; i < 52; i ++){

            ProfileDTO profileDTO = new ProfileDTO();
            profileDTO.setProfilePath("path");

            UserProfileEntity userProfileEntity = profileDTO.toEntity();

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("test " + i);
            userDTO.setPassword("password");
            userDTO.setProfile(userProfileEntity);

            userRepository.save(userDTO.toEntity());
        }
    }

    @Test
    void 그룹생성(){
        groupRepository.deleteAll();
        for(int i = 1; i < 52; i ++){
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setTitle("test " + i);
            groupRepository.save(groupDTO.toEntity());
        }
    }

    @Test
    void 조인테이블_생성(){
        UserEntity userEntity = userRepository.getById(3L);
        for(int i = 26; i < 30; i ++){
            GroupEntity groupEntity = groupRepository.getById(4L);
            UserGroupJoinDTO userGroupJoinDTO = new UserGroupJoinDTO();
            userGroupJoinDTO.setUser(userEntity);
            userGroupJoinDTO.setGroup(groupEntity);
            userGroupJoinRepository.save(userGroupJoinDTO.toEntity());
        }
    }

    @Test
    void 게시글_생성(){

    }

}
