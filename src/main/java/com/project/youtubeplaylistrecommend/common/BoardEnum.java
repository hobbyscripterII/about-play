package com.project.youtubeplaylistrecommend.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardEnum {
    NOTICE(1, "공지 게시판"),
    MUSIC_RECOMMEND(2, "플레이리스트 추천"),
    FREE(3, "자유 게시판");

    private int category;
    private String title;
}
