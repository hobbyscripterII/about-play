package com.project.youtubeplaylistrecommend.genre;

import com.project.youtubeplaylistrecommend.entity.GenreCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreCodeEntity, Long> {
    List<GenreCodeEntity> findAllBy();
}
