package com.project.youtubeplaylistrecommend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Entity
@Table(name = "board_heart_tbl")
public class BoardHeartEntity {
    @Data
    @Embeddable
    @EqualsAndHashCode
    public class BoardHeartIds implements Serializable {
        @Column(columnDefinition = "BIGINT UNSIGNED")
        private long iboard;
        @Column(columnDefinition = "BIGINT UNSIGNED")
        private long iuser;
    }

    @EmbeddedId
    private BoardHeartIds boardHeartIds;

    @ManyToOne
    @MapsId("iboard")
    @JoinColumn(columnDefinition = "BIGINT UNSIGNED", name = "iboard")
    private BoardEntity boardEntity;

    @ManyToOne
    @MapsId("iuser")
    @JoinColumn(columnDefinition = "BIGINT UNSIGNED", name = "iuser")
    private UserEntity userEntity;
}
