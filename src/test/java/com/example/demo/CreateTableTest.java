package com.example.demo;

import com.example.demo.dto.*;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.GroupUserEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserProfileEntity;
import com.example.demo.repositories.*;
import com.querydsl.core.Tuple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.yml")
public class CreateTableTest {

    @Autowired private UserRepository userRepository;
    @Autowired private GroupRepository groupRepository;
    @Autowired private GroupBoardRepository groupBoardRepository;
    @Autowired private GroupUserRepository groupUserRepository;
    @Autowired private GroupUserQueryRepository groupUserQueryRepository;

    private static final Logger log = LogManager.getLogger();

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
    void 그룹가입(){

        GroupEntity groupEntity = groupRepository.getById(1L);

        GroupUserDTO groupUserDTO = new GroupUserDTO();
        groupUserDTO.setUserId(1L);
        groupUserDTO.setGroup(groupEntity);

        groupUserRepository.save(groupUserDTO.toEntity());

        List<UserEntity> userEntity = groupUserQueryRepository.getUserEntity(52L);

        log.info("value : ");
    }

    @Test
    void 게시글_생성(){

        UserEntity userEntity = userRepository.getById(3L);
        GroupEntity groupEntity = groupRepository.getById(3L);

        for(int i = 0; i < 23; i ++){
            GroupBoardDTO groupBoardDTO = new GroupBoardDTO();
            groupBoardDTO.setTitle("title " + i);
            groupBoardDTO.setContent("subject " + i);
            groupBoardDTO.setGroup_id(groupEntity.getId());
            groupBoardDTO.setUser(userEntity);
            groupBoardDTO.setGroup(groupEntity);

            groupBoardRepository.save(groupBoardDTO.toEntity());
        }
    }
}
