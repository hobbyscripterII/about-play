package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.BoardEntity;
import com.project.youtubeplaylistrecommend.entity.QBoardEntity;
import com.project.youtubeplaylistrecommend.entity.QPlaylistEntity;
import com.project.youtubeplaylistrecommend.entity.QUserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BoardQdlsRepositoryImpl implements BoardQdlsRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUserEntity user = new QUserEntity("user");
    private final QBoardEntity board = new QBoardEntity("board");
    private final QPlaylistEntity playlist = new QPlaylistEntity("playlist");

    @Override
    public List<BoardEntity> getPlaylistBoard(Pageable pageable) {
        return jpaQueryFactory
                .select(board)
                .from(board)
                .join(playlist)
                .on(board.iboard.eq(playlist.boardEntity.iboard))
                .join(user)
                .on(board.userEntity.iuser.eq(user.iuser))
                .where()
                .fetch();
    }
}
