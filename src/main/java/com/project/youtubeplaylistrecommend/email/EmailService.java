package com.project.youtubeplaylistrecommend.email;

import com.project.youtubeplaylistrecommend.entity.EmailAuthEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    @Value("${mail.email}")
    private String email;

    @Transactional
    public boolean emailSend(String email) {
        try {
            String from = this.email;
            String randomCode = String.valueOf(UUID.randomUUID()).substring(0, 5);

            String title = "어바웃 플레이 회원가입 인증 이메일입니다.";
            StringBuilder content_ = new StringBuilder();
            content_.append("<h2>어바웃 플레이를 방문해주셔서 감사합니다.</h2>");
            content_.append("인증 코드는<strong>" + randomCode + "</strong>입니다.");
            content_.append("<br>");
            content_.append("이메일 인증 창에 이메일 인증 코드를 입력해주세요.");
            String content = String.valueOf(content_);

            MimeMessage mm = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(content, true);
            javaMailSender.send(mm);

            EmailAuthEntity emailAuthEntity = new EmailAuthEntity();
            emailAuthEntity.setEmail(email);
            emailAuthEntity.setAuthCode(randomCode);
            emailRepository.save(emailAuthEntity);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
