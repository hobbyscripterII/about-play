package com.project.youtubeplaylistrecommend.youtube.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class YoutubeInfoGetVo {
    private String title;
    private String videoUrl;
    private String thumbnailUrl;
    private String description;
}
