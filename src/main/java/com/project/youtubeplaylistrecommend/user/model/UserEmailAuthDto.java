package com.project.youtubeplaylistrecommend.user.model;

import lombok.Data;

@Data
public class UserEmailAuthDto {
    private String email;
    private String emailAuthCode;
}
