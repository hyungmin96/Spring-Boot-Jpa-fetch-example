package com.example.demo.repositories;

import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.GroupEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserGroupJoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupJoinRepository extends JpaRepository<UserGroupJoinEntity, Long> {

    @Query(value = "select g from GroupEntity g join fetch g.UserGroupJoin u where u.user = :name")
    List<GroupEntity> findAllGroup(UserEntity name);

    @Query(value = "select u from UserEntity u join fetch u.UserGroupJoin g where g.group = :name")
    List<UserEntity> findAllUser(GroupEntity name);

    @Query(value = "select u from UserGroupJoinEntity u join fetch u.user g join fetch u.group h join fetch g.profile where g = :user And h = :group")
    UserGroupJoinEntity findByuserAndGroup(UserEntity user, GroupEntity group);

}
