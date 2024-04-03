package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "playlist_tbl")
public class PlaylistEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iplaylist;

    // @ManyToOne + @JoinColumn - fk 지정
    // @JoinColumn의 name - 부모 테이블의 pk 멤버변수
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
