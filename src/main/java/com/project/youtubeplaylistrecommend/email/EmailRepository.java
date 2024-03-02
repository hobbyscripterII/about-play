package com.project.youtubeplaylistrecommend.email;

import com.project.youtubeplaylistrecommend.entity.EmailAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailAuthEntity, Long> {

}
