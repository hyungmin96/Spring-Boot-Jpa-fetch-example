package com.example.demo.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_user_group_join")
public class GroupUserEntity extends BaseTimeEntity{

    @Id @GeneratedValue
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_table")
    private GroupEntity group;

}
