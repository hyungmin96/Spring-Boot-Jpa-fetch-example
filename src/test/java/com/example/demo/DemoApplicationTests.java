package com.example.demo;

import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserGroupJoinDTO;
import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserGroupJoinEntity;
import com.example.demo.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.yml")
public class DemoApplicationTests {

    @Autowired private UserRepository userRepository;
    @Autowired private GroupRepository groupRepository;
    @Autowired private UserGroupJoinRepository userGroupJoinRepository;
    @Autowired private GroupBoardQueryRepository groupBoardQueryRepository;
    @Autowired private GroupBoardRepository groupBoardRepository;

    private static final Logger log = LogManager.getLogger();

    @Test
    void 유저_삭제(){
        userRepository.deleteById(1L);
    }

    @Test
    void 그룹_삭제(){
        groupRepository.deleteById(1L);
    }

    @Test
    @Transactional
    void 유저_가입된그룹정보_가져오기(){
        UserEntity userEntity = userRepository.getById(2L);
        GroupEntity groupEntity = groupRepository.getById(4L);

        List<UserEntity> list = userGroupJoinRepository.findAllUser(groupEntity);

        for(UserEntity item : list)
            log.info("value : " + item.getUsername());
    }

    @Test
    void 그룹_게시글_가져오기(){

        GroupEntity groupEntity = groupRepository.getById(3L);
        PageRequest request = PageRequest.of(0, 5, Sort.Direction.ASC, "id");

        List<GroupBoardEntity> items = groupBoardRepository.findAllBygroup(groupEntity, request);

        for(GroupBoardEntity item : items)
            log.info("\nvalue : " + item.getTitle());
    }

    @Test
    void Querydsl_게시물_가져오기(){
        List<GroupBoardEntity> list = groupBoardQueryRepository.findByName("title 1");

        for(GroupBoardEntity group : list)
            log.info("\nvalue : " + group.getTitle() + "\n" + group.getUser().getId());
    }

}
