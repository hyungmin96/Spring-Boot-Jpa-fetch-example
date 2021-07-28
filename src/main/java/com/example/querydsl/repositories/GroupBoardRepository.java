package com.example.querydsl.repositories;

import com.example.querydsl.entities.GroupBoardEntity;
import com.example.querydsl.entities.GroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupBoardRepository extends JpaRepository<GroupBoardEntity, Long> {

//    @Query(value = "select b from GroupBoardEntity b join fetch b.user g join fetch g.profile")
    List<GroupBoardEntity> findAllBygroup(GroupEntity group, Pageable request);

}