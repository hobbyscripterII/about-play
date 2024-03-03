package com.project.youtubeplaylistrecommend.genre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GenreGetVo {
    private long igenre;
    private String genreName;
}
