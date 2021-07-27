package com.example.demo.repositories;

import com.example.demo.entities.QGroupBoardEntity;
import com.example.demo.entities.GroupBoardEntity;
import com.example.demo.entities.QUserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupBoardQueryRepository{

    private final JPAQueryFactory queryFactory;
    QGroupBoardEntity groupBoardEntity = QGroupBoardEntity.groupBoardEntity;
    QUserEntity userEntity = QUserEntity.userEntity;

    public List<GroupBoardEntity> findByName(String title) {
        return queryFactory
                .selectFrom(groupBoardEntity)
                .join(groupBoardEntity.user, userEntity).fetchJoin()
                .innerJoin(userEntity.profile).fetchJoin()
                .where(groupBoardEntity.title.eq(title))
                .offset(0)
                .limit(15)
                .fetch();
    }
}