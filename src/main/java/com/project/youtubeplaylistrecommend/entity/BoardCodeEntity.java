package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "board_code_tbl")
public class BoardCodeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iboardcode;

    @Column(length = 20, nullable = false)
    private String boardName;
}
