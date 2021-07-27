package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tbl_user")
@Builder
public class UserEntity extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GroupBoardEntity> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GroupBoardCommentEntity> comments;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private UserProfileEntity profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroupJoinEntity> UserGroupJoin;

}
