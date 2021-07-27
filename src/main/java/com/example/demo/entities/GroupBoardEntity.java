package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_group_board")
public class GroupBoardEntity extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_no")
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_board_writer")
    private UserEntity user;

    @OneToMany(mappedBy = "board")
    private List<GroupBoardCommentEntity> comments;

    @OneToMany(mappedBy = "board")
    private List<GroupBoardFileEntity> files;

}
