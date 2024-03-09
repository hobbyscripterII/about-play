package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.entity.*;
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
    public List<PlaylistEntity> getPlaylistBoard(Pageable pageable) {
        return jpaQueryFactory
                .select(playlist)
                .from(playlist)
                .join(board)
                .on(playlist.boardEntity.iboard.eq(board.iboard))
                .join(user)
                .on(board.userEntity.iuser.eq(user.iuser))
                .where()
                .fetch();
    }

    @Override
    public List<PlaylistEntity> selPlaylistBoard(long iboard) {
        return jpaQueryFactory
                .select(playlist)
                .from(playlist)
                .join(board)
                .on(playlist.boardEntity.iboard.eq(board.iboard))
                .join(user)
                .on(board.userEntity.iuser.eq(user.iuser))
                .where(playlist.boardEntity.iboard.eq(iboard))
                .fetch();
    }
}
