package com.project.youtubeplaylistrecommend.playlist;

import com.project.youtubeplaylistrecommend.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {

}
