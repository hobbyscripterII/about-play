package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false, nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime firstCreatedAt;

    @CreatedBy
    @Column(updatable = false, columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private Long firstCreatedUser;

    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    @LastModifiedBy
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long lastUpdatedUser;
}
