package com.project.youtubeplaylistrecommend.email.model;

import lombok.Data;

@Data
public class EmailSendDto {
    private String email;
    private String emailAuthCode;
}
