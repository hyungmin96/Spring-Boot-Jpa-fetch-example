package com.example.querydsl.repositories;

import com.example.querydsl.component.PagingUtil;
import com.example.querydsl.dto.UserDTO;
import com.example.querydsl.entities.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.querydsl.entities.QGroupBoardEntity.groupBoardEntity;
import static com.example.querydsl.entities.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class QuerydlsRepository{

    private final JPAQueryFactory queryFactory;
    private final PagingUtil pagingUtil;

    public List<UserDTO> findDTO() {
        return queryFactory.from(userEntity)
                .select(Projections.fields(UserDTO.class,
                        userEntity.id,
                        userEntity.username))
                .fetch();
    }

    public PageImpl<UserDTO> findByName(Pageable page) {
        JPAQuery<UserDTO> query = queryFactory.from(userEntity)
                .select(Projections.fields(UserDTO.class,
                        userEntity.id,
                        userEntity.username)
                );


        return pagingUtil.getPageImpl(page, query, UserDTO.class);
    }
}