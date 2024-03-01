package com.project.youtubeplaylistrecommend.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardEnum {
    NOTICE(1, "notice"),
    MUSIC_RECOMMEND(2, "playlist"),
    FREE(3, "free");

    private int category;
    private String title;
}
