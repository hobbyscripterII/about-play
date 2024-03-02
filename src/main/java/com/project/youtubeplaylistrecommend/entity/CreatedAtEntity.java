package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CreatedAtEntity {
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime firstCreatedAt;
    @Column(columnDefinition = "BIGINT UNSIGNED", nullable = false)
    private long firstCreatedUser;
}
