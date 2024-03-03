package com.project.youtubeplaylistrecommend.email.model;

import lombok.Data;

@Data
public class EmailAuthCodeGetDto {
    private String email;
    private String code;
}
