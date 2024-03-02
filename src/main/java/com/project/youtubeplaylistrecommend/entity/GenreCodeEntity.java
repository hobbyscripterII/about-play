package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "genre_code_tbl")
@Entity
public class GenreCodeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long igenre;

    @Column(length = 20, nullable = false)
    private String genreName;
}
