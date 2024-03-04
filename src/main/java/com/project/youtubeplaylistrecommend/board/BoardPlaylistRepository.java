package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.BoardEntity;
import com.project.youtubeplaylistrecommend.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardPlaylistRepository extends JpaRepository<PlaylistEntity, Long> {

}
