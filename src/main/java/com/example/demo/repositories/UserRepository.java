package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserGroupJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
