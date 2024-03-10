package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardQdlsRepository {

}
