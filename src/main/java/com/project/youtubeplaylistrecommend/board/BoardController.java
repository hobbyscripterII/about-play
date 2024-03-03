package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.common.BoardEnum;
import com.project.youtubeplaylistrecommend.genre.GenreService;
import com.project.youtubeplaylistrecommend.genre.model.GenreGetVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final GenreService genreService;

    @GetMapping
    public String getBoard(@RequestParam(name = "code") int code, Model model) {
        model.addAttribute("title", getBoardName(code));
        if (code == BoardEnum.MUSIC_RECOMMEND.getCode()) {
            return "/board/list-playlist";
        }
        return "/board/list";
    }

    @GetMapping("/write")
    public String insBoard(@RequestParam(name = "code") int code, Model model) {
        if (code == BoardEnum.MUSIC_RECOMMEND.getCode()) {
            model.addAttribute("code", code);
            model.addAttribute("genre", genreService.getGenre());
            return "/board/write-playlist";
        }
        return "/home";
    }

    private String getBoardName(int code) {
        if (code == 0) {
            return null;
        } else {
            String codeToString = null;

            switch (code) {
                case 1 -> codeToString = BoardEnum.NOTICE.getName();
                case 2 -> codeToString = BoardEnum.MUSIC_RECOMMEND.getName();
                case 3 -> codeToString = BoardEnum.FREE.getName();
            }
            return codeToString;
        }
    }
}
