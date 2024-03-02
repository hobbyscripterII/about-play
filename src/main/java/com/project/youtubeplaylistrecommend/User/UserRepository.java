package com.project.youtubeplaylistrecommend.User;

import com.project.youtubeplaylistrecommend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
