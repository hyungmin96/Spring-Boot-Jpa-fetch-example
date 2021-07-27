package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_group_board_comments")
public class GroupBoardCommentEntity {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_comment_writer")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_no")
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private GroupBoardEntity board;

    @Column(name = "comment_content")
    private String comment;

}
