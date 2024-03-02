package com.project.youtubeplaylistrecommend.user;

import com.project.youtubeplaylistrecommend.user.model.UserEmailAuthDto;
import com.project.youtubeplaylistrecommend.user.model.UserSignUpDto;
import com.project.youtubeplaylistrecommend.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.util.UUID;

import static com.project.youtubeplaylistrecommend.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final JavaMailSender javaMailSender;

    @Value("${mail.email}")
    private String email;

    @Transactional
    public int signUp(UserSignUpDto dto) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(dto.getEmail());
            userEntity.setPwd(dto.getPwd());
            userEntity.setName(dto.getName());
//            userEntity.setPic(dto.getPic());
            userRepository.save(userEntity);
            return SUCCESS;
        } catch(Exception e) {
            throw new NullPointerException();
        }
    }

//   public boolean emailSend(String email) {
//        String from = this.email;
//        String randomCode = String.valueOf(UUID.randomUUID()).substring(0, 5);
//
//        String title = "어바웃 플레이 회원가입 인증 이메일입니다.";
//        StringBuilder content_ = new StringBuilder();
//        content_.append("<h2>어바웃 플레이를 방문해주셔서 감사합니다.</h2>");
//        content_.append("인증 코드는<strong>" + randomCode + "</strong>입니다.");
//        content_.append("<br>");
//        content_.append("이메일 인증 창에 이메일 인증 코드를 입력해주세요.");
//        String content = String.valueOf(content_);
//
//        MimeMessage mm = javaMailSender.createMimeMessage();
//
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");
//            helper.setFrom(from);
//            helper.setTo(email);
//            helper.setSubject(title);
//            helper.setText(content, true);
//            javaMailSender.send(mm);
//
//            UserEmailAuthDto dto = new UserEmailAuthDto();
//            dto.setEmail(email);
//            dto.setEmailAuthCode(randomCode);
//
//            return Utils.isNotNull(insertEmailAuthCode(dto)) ? true : false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
