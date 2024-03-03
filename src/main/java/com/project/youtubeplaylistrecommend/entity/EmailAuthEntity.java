package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email_auth_tbl")
@EntityListeners(AuditingEntityListener.class)
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
    @Column(updatable = false, nullable = false)
    private LocalDateTime issuedAt;

    @Column(updatable = false)
    private LocalDateTime authedAt;
}
