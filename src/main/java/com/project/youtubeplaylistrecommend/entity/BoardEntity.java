package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

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

    // mappedBy - N 관계 테이블의 fk 컬럼에 해당되는 멤버변수명
    // orphanRemoval - 고아 객체 제거
    @OneToMany(mappedBy = "boardEntity", orphanRemoval = true) // 1:N
    @ToString.Exclude
    private List<PlaylistEntity> playlistEntity = new ArrayList();
}
