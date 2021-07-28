package com.example.querydsl;

import com.example.querydsl.dto.UserDTO;
import com.example.querydsl.entities.UserEntity;
import com.example.querydsl.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.yml")
public class DemoApplicationTests {

    @Autowired private UserRepository userRepository;
    @Autowired private GroupRepository groupRepository;
    @Autowired private QuerydlsRepository groupBoardQueryRepository;
    @Autowired private GroupBoardRepository groupBoardRepository;

    private static final Logger log = LogManager.getLogger();

    @Test
    void findStaffJoinOrderPaging_test_if_use_pageable() {
        // when

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "id");

//        PageImpl<UserDTO> pageImplStaff = groupBoardQueryRepository.findByName(pageable);  // test

        List<UserDTO> pageImplStaff = groupBoardQueryRepository.findDTO();

        for(UserDTO user : pageImplStaff)
            log.info("value : " + user.getUsername());
    }

}
