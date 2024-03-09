package com.project.youtubeplaylistrecommend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BoardPlaylistSelVo {
    private long iboard;
    private String title;
    private LocalDateTime createdAt;
    private String nm;
    private String genre;
    private List<Playlist> playlists;

    @Data
    @Builder
    @AllArgsConstructor
    public static class Playlist {
        private String videoId;
        private String description;
    }
}
