package com.example.demo;

import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
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
    @Autowired private GroupBoardQueryRepository groupBoardQueryRepository;
    @Autowired private GroupBoardRepository groupBoardRepository;

    private static final Logger log = LogManager.getLogger();



}
