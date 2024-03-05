package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.board.model.BoardPlaylistInsDto;
import com.project.youtubeplaylistrecommend.entity.*;
import com.project.youtubeplaylistrecommend.genre.GenreRepository;
import com.project.youtubeplaylistrecommend.security.MyAuthentication;
import com.project.youtubeplaylistrecommend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.youtubeplaylistrecommend.common.Const.FAIL;
import static com.project.youtubeplaylistrecommend.common.Const.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final BoardPlaylistRepository boardPlaylistRepository;
    private final BoardCodeRepository boardCodeRepository;
    private final GenreRepository genreRepository;

    @Transactional
    public long insPlaylistBoard(BoardPlaylistInsDto dto) {
        try {
            long iuser = MyAuthentication.myUserDetails().getIuser();
            BoardEntity boardEntity = new BoardEntity();
            UserEntity userEntity = userRepository.getReferenceById(iuser);
            GenreCodeEntity genreCodeEntity = genreRepository.getReferenceById(dto.getGenre());
            BoardCodeEntity boardCodeEntity = boardCodeRepository.getReferenceById(dto.getCode());
            boardEntity.setUserEntity(userEntity);
            boardEntity.setGenreCodeEntity(genreCodeEntity);
            boardEntity.setBoardCodeEntity(boardCodeEntity);
            boardEntity.setTitle(dto.getTitle());
            boardRepository.save(boardEntity);

            for (BoardPlaylistInsDto.Playlist list : dto.getPlaylist()) {
                PlaylistEntity playlistEntity = new PlaylistEntity();
                playlistEntity.setBoardEntity(boardEntity);
                playlistEntity.setVideoId(list.getVideoId());
                playlistEntity.setDescription(list.getDescription());
                boardPlaylistRepository.save(playlistEntity);
            }
            return boardEntity.getIboard();
        } catch (Exception e) {
            return FAIL;
        }
    }
}