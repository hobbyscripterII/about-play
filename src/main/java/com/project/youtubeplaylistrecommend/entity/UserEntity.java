package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_tbl",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long iuser;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String kakaoId;

    @Column(length = 500, nullable = false)
    private String pwd;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 200)
    private String pic;

    @Column(length = 10, nullable = false)
    @ColumnDefault("'USER'")
    private String role;

    @Column(columnDefinition = "UNSIGNED", nullable = false)
    @ColumnDefault("'0'")
    private int visit;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    @ColumnDefault("'N'")
    private char leaveFl;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    @ColumnDefault("'N'")
    private char deleteFl;

//    @CreatedDate
//    @Column(updatable = false, nullable = false)
//    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
