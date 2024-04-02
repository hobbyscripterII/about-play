package com.project.youtubeplaylistrecommend.board.model;

import lombok.Data;

import java.util.List;

@Data
public class BoardPlaylistInsDto {
    private long iboard;
    private long code;
    private long genre;
    private String title;
    private List<Playlist> playlist;

    @Data
    public static class Playlist {
        private long iplaylist;
        private String videoId;
        private String description;
    }
}
