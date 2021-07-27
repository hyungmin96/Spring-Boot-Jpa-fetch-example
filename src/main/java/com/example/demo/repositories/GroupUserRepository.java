package com.example.demo.repositories;

import com.example.demo.entities.GroupUserEntity;
import com.example.demo.entities.QGroupUserEntity;
import com.example.demo.entities.QUserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GroupUserRepository extends JpaRepository<GroupUserEntity, Long> {



}

