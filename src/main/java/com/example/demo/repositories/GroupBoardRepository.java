package com.example.demo.repositories;

import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupBoardRepository extends JpaRepository<GroupBoardEntity, Long> {

//    @Query(value = "select b from GroupBoardEntity b join fetch b.user g join fetch g.profile")
    List<GroupBoardEntity> findAllBygroup(GroupEntity group, Pageable request);

}