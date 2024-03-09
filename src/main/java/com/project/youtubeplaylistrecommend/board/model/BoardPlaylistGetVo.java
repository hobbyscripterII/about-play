package com.project.youtubeplaylistrecommend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BoardPlaylistGetVo {
    private long iboard;
    private String title;
    private LocalDateTime createdAt;
    private int view;
    private int heart;
    private String name;
    private String videoId;
    private String description;
}
