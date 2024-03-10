package com.project.youtubeplaylistrecommend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BoardPlaylistSelVo { // 게시글 읽기, 수정 공용
    private long iboard;
    private long iuser;
    private String title;
    private LocalDateTime createdAt;
    private String nm;
    private String genre;
    private List<Playlist> playlist;

    @Data
    @Builder
    @AllArgsConstructor
    public static class Playlist {
        private String videoId;
        private String description;
    }
}
