package com.project.youtubeplaylistrecommend.email;

import com.project.youtubeplaylistrecommend.entity.EmailAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAuthRepository extends JpaRepository<EmailAuthEntity, Long> {
    EmailAuthEntity findByEmail(String email);
    int countByEmailAndAuthCode(String email, String authCode);
}
