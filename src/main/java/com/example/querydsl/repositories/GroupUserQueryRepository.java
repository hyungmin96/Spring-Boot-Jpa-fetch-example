package com.example.querydsl.repositories;

import com.example.querydsl.entities.QGroupUserEntity;
import com.example.querydsl.entities.QUserEntity;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GroupUserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    QUserEntity userEntity = QUserEntity.userEntity;
    QGroupUserEntity groupUserEntity = QGroupUserEntity.groupUserEntity;

    public Tuple getUserEntity(Long userId){
        return jpaQueryFactory
                .select(userEntity.username, userEntity.id, userEntity.profile.profilePath)
                .from(userEntity)
                .where(userEntity.id.eq(userId))
                .fetchOne();
    }
}
