package com.project.youtubeplaylistrecommend.playlist;

import com.project.youtubeplaylistrecommend.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
    @Modifying
    @Query("delete from PlaylistEntity p where p.boardEntity.iboard = :iboard")
    void deleteByIboard(@Param("iboard") long iboard);
}