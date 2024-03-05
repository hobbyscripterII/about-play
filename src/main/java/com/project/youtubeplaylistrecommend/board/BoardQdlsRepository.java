package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.BoardEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardQdlsRepository {
    List<BoardEntity> getPlaylistBoard(Pageable pageable);
}
