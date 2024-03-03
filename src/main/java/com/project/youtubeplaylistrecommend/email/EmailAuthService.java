package com.project.youtubeplaylistrecommend.email;

import com.project.youtubeplaylistrecommend.common.Const;
import com.project.youtubeplaylistrecommend.common.Utils;
import com.project.youtubeplaylistrecommend.email.model.EmailAuthCodeGetDto;
import com.project.youtubeplaylistrecommend.entity.EmailAuthEntity;
import com.project.youtubeplaylistrecommend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.project.youtubeplaylistrecommend.common.Const.FAIL;
import static com.project.youtubeplaylistrecommend.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailAuthService {
    private final EmailAuthRepository emailAuthRepository;
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;

    @Value("${email.mail.email}")
    private String email;

    public int emailCheck(String email) {
        long result = userRepository.countByEmail(email);
        if (Utils.isNull(result)) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Transactional
    public int emailSend(String email) {
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

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);

            EmailAuthEntity findEntity = emailAuthRepository.findByEmail(email);
            if (Utils.isNotNull(findEntity)) {
                findEntity.setEmail(email);
                findEntity.setAuthCode(randomCode);
                emailAuthRepository.save(findEntity);
            } else {
                EmailAuthEntity emailAuthEntity = new EmailAuthEntity();
                emailAuthEntity.setIauth(emailAuthEntity.getIauth());
                emailAuthEntity.setEmail(email);
                emailAuthEntity.setAuthCode(randomCode);
                emailAuthRepository.save(emailAuthEntity);
            }
            return SUCCESS;
        } catch (Exception e) {
            return FAIL;
        }
    }

    public int emailAuthCodeCheck(EmailAuthCodeGetDto dto) {
        int result = emailAuthRepository.countByEmailAndAuthCode(dto.getEmail(), dto.getCode());
        EmailAuthEntity emailAuthEntity = emailAuthRepository.findByEmail(dto.getEmail());
        emailAuthEntity.setAuthedAt(LocalDateTime.now()); // 값 안들어감 추후 수정
        emailAuthEntity.setAuthFl(Const.AUTH_SUCCESS_FL);
        emailAuthRepository.save(emailAuthEntity);

        if(Utils.isNotNull(result)) {
            return SUCCESS;
        }
        return FAIL;
    }

    public int emailAuthCheck(String email) {
        EmailAuthEntity emailAuthEntity = emailAuthRepository.findByEmail(email);
        char authFl = emailAuthEntity.getAuthFl();
        return authFl == Const.AUTH_SUCCESS_FL ? SUCCESS : FAIL;
    }
}
