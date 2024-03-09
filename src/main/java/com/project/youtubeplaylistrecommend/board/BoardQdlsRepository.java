package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.PlaylistEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQdlsRepository {
    List<PlaylistEntity> getPlaylistBoard(Pageable pageable);
}
