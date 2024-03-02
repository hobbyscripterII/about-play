package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "board_tbl")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iboard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iboardcode")
    private BoardCodeEntity boardCodeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igenre")
    private GenreCodeEntity genreCodeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iuser")
    private UserEntity userEntity;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    @ColumnDefault("'0'")
    private int heart;

    @Column(columnDefinition = "INT UNSIGNED", nullable = false)
    @ColumnDefault("'0'")
    private int view;
}
