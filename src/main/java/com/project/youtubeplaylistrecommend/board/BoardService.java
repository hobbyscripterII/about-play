package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.board.model.BoardPlaylistGetVo;
import com.project.youtubeplaylistrecommend.board.model.BoardPlaylistInsDto;
import com.project.youtubeplaylistrecommend.board.model.BoardPlaylistSelVo;
import com.project.youtubeplaylistrecommend.common.Utils;
import com.project.youtubeplaylistrecommend.entity.*;
import com.project.youtubeplaylistrecommend.genre.GenreRepository;
import com.project.youtubeplaylistrecommend.playlist.PlaylistRepository;
import com.project.youtubeplaylistrecommend.security.MyAuthentication;
import com.project.youtubeplaylistrecommend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.project.youtubeplaylistrecommend.common.Const.FAIL;
import static com.project.youtubeplaylistrecommend.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final PlaylistRepository playlistRepository;
    private final BoardCodeRepository boardCodeRepository;
    private final GenreRepository genreRepository;

    @Transactional
    public long insPlaylistBoard(BoardPlaylistInsDto dto) {
        try {
            long iuser = MyAuthentication.myUserDetails().getIuser();
            long iboard = dto.getIboard();

            if (Utils.isNotNull(iboard)) {
                boardRepository.findById(iboard).ifPresent((e) -> {
                    insPlaylistBoard(dto, e);
                });
            } else {
                BoardEntity boardEntity = new BoardEntity();
                UserEntity userEntity = userRepository.getReferenceById(iuser);
                GenreCodeEntity genreCodeEntity = genreRepository.getReferenceById(dto.getGenre());
                BoardCodeEntity boardCodeEntity = boardCodeRepository.getReferenceById(dto.getCode());
                insPlaylistBoard(dto, boardEntity, userEntity, genreCodeEntity, boardCodeEntity);
                iboard = boardEntity.getIboard();
            }
            return iboard;
        } catch (Exception e) {
            return FAIL;
        }
    }

    private void insPlaylistBoard(BoardPlaylistInsDto dto, BoardEntity boardEntity) {
        boardEntity.setUserEntity(boardEntity.getUserEntity());
        boardEntity.setGenreCodeEntity(boardEntity.getGenreCodeEntity());
        boardEntity.setBoardCodeEntity(boardEntity.getBoardCodeEntity());
        boardEntity.setTitle(dto.getTitle());
        boardRepository.save(boardEntity);

        for (BoardPlaylistInsDto.Playlist list : dto.getPlaylist()) {
            boardEntity.getPlaylistEntity().stream()
                    .filter(e -> e.getIplaylist() != list.getIplaylist())
                    .map(e -> {
                        playlistRepository.delete(playlistRepository.getReferenceById(e.getIplaylist()));
                        return e.getIplaylist();
                    })
                    .collect(Collectors.toList());

            Optional<PlaylistEntity> optionalPlaylistEntity = playlistRepository.findById(list.getIplaylist());

            optionalPlaylistEntity.ifPresent(e -> {
                e.setBoardEntity(boardEntity);
                e.setVideoId(list.getVideoId());
                e.setDescription(list.getDescription());
            });

            optionalPlaylistEntity.orElseGet(() -> {
                PlaylistEntity playlistEntity = new PlaylistEntity();
                playlistEntity.setBoardEntity(boardEntity);
                playlistEntity.setVideoId(list.getVideoId());
                playlistEntity.setDescription(list.getDescription());
                playlistRepository.save(playlistEntity);
                return playlistEntity;
            });
        }
    }

    private void insPlaylistBoard(BoardPlaylistInsDto dto, BoardEntity boardEntity, UserEntity userEntity, GenreCodeEntity genreCodeEntity, BoardCodeEntity boardCodeEntity) {
        boardEntity.setUserEntity(userEntity);
        boardEntity.setGenreCodeEntity(genreCodeEntity);
        boardEntity.setBoardCodeEntity(boardCodeEntity);
        boardEntity.setTitle(dto.getTitle());
        boardRepository.save(boardEntity);

        for (BoardPlaylistInsDto.Playlist list : dto.getPlaylist()) {
            Optional<PlaylistEntity> optionalPlaylistEntity = playlistRepository.findById(list.getIplaylist());
            PlaylistEntity playlistEntity = optionalPlaylistEntity.orElseGet(PlaylistEntity::new);
            playlistEntity.setBoardEntity(boardEntity);
            playlistEntity.setVideoId(list.getVideoId());
            playlistEntity.setDescription(list.getDescription());
            playlistRepository.save(playlistEntity);
        }
    }

    @Transactional
    public int delBoard(int iboard) {
        try {
            Optional<BoardEntity> optionalBoardEntity = boardRepository.findById((long) iboard);
            if (optionalBoardEntity.isPresent()) {
                BoardEntity boardEntity = optionalBoardEntity.get();
                playlistRepository.deleteByIboard(iboard);
                boardRepository.delete((boardEntity));
                return SUCCESS;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Transactional
    public List<BoardPlaylistGetVo> getPlaylistBoard(Pageable pageable) {
        try {
            return boardRepository.getPlaylistBoard(pageable)
                    .stream()
                    .map(item -> BoardPlaylistGetVo
                            .builder()
                            .iboard(item.getBoardEntity().getIboard())
                            .title(item.getBoardEntity().getTitle())
                            .createdAt(item.getFirstCreatedAt())
                            .view(item.getBoardEntity().getView())
                            .heart(item.getBoardEntity().getHeart())
                            .name(item.getBoardEntity().getUserEntity().getName())
                            .videoId(item.getVideoId())
                            .description(item.getDescription())
                            .build())
                    .toList();
        } catch (Exception e) {
            // 추후 수정
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public BoardPlaylistSelVo selPlaylistBoard(long iboard) {
        Optional<BoardEntity> allById = boardRepository.findById(iboard);

        try {
            if (allById.isPresent()) {
                BoardEntity boardEntity = allById.get();
                return BoardPlaylistSelVo
                        .builder()
                        .iboard(boardEntity.getIboard())
                        .igenre(boardEntity.getGenreCodeEntity().getIgenre())
                        .iuser(boardEntity.getUserEntity().getIuser())
                        .title(boardEntity.getTitle())
                        .createdAt(boardEntity.getFirstCreatedAt())
                        .nm(boardEntity.getUserEntity().getName())
                        .genre(boardEntity.getGenreCodeEntity().getGenreName())
                        .playlist(boardRepository.selPlaylistBoard(iboard)
                                .stream()
                                .map(item -> BoardPlaylistSelVo.Playlist.builder()
                                        .iplaylist(item.getIplaylist())
                                        .videoId(item.getVideoId())
                                        .description(item.getDescription())
                                        .build())
                                .toList())
                        .build();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}