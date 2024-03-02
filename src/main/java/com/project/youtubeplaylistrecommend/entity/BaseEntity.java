package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends CreatedAtEntity {
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    @LastModifiedBy
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long lastUpdatedUser;
}
