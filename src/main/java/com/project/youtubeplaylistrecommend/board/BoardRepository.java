package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
