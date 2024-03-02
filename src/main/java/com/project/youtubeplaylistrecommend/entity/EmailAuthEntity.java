package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email_auth_tbl")
public class EmailAuthEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iauth;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 5, nullable = false)
    private String authCode;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    @ColumnDefault("'N'")
    private char authFl;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime issuedAt;

    private LocalDateTime authedAt;
}
