package com.example.demo.repositories;

import com.example.demo.entities.GroupUserEntity;
import com.example.demo.entities.QGroupUserEntity;
import com.example.demo.entities.QUserEntity;
import com.example.demo.entities.UserEntity;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupUserQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QUserEntity userEntity = QUserEntity.userEntity;
    QGroupUserEntity groupUserEntity = QGroupUserEntity.groupUserEntity;

    public List<UserEntity> getUserEntity(Long userId){
        return jpaQueryFactory
                .select(userEntity)
                .from(groupUserEntity)
                .leftJoin(userEntity).on(userEntity.id.eq(userId))
                .fetch();
    }
}
