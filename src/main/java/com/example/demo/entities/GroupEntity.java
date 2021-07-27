package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tbl_group")
@Builder
public class GroupEntity {

    @Id @GeneratedValue
    private Long id;

    private String groupTitle;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<UserGroupJoinEntity> UserGroupJoin;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<GroupBoardEntity> boards;

}
