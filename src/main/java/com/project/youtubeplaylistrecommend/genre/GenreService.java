package com.project.youtubeplaylistrecommend.genre;

import com.project.youtubeplaylistrecommend.genre.model.GenreGetVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<GenreGetVo> getGenre() {
        return genreRepository.findAllBy()
                .stream()
                .map(item -> GenreGetVo
                            .builder()
                            .igenre(item.getIgenre())
                            .genreName(item.getGenreName())
                            .build())
                .toList();
    }
}
