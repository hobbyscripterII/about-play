package com.project.youtubeplaylistrecommend.user;

import com.project.youtubeplaylistrecommend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    long countByEmail(String email);
    long countByName(String name);
}
