package com.project.youtubeplaylistrecommend.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignUpDto {
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;
    private String pwd;
    @NotEmpty(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 7, message = "닉네임은 2~7자 내외로 입력해주세요.")
    private String name;
    private String pic;
    @NotNull(message = "성별을 선택해주세요.") // @NotEmpty는 문자열만 가능, 라디오 버튼은 @NotNull 사용
    private String gender;
    @NotEmpty(message = "생년월일을 선택해주세요.")
    private String birth;
}
