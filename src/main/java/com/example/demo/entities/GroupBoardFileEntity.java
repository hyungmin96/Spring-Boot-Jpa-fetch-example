package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_group_board_files")
public class GroupBoardFileEntity {

    @Id @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @Column(name = "file_path")
    private String path;

    @Column(name = "file_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private GroupBoardEntity board;

}
