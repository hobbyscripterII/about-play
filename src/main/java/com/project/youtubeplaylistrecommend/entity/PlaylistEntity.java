package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Data
@Entity
@Table(name = "playlist_tbl")
public class PlaylistEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iplaylist;

    // @ManyToOne + @JoinColumn - fk 지정
    @ManyToOne(fetch = FetchType.LAZY) // N:1
    @JoinColumn(name = "iboard", columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private BoardEntity boardEntity;

    @Column(length = 100, nullable = false)
    private String videoId;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    @ColumnDefault("'N'")
    private char thumbnailFl;
}
