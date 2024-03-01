package com.project.youtubeplaylistrecommend.board;

import com.project.youtubeplaylistrecommend.common.BoardEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    @GetMapping
    public String getBoard(@RequestParam int category, Model model) {
        model.addAttribute("title", getBoardTitle(category));
        return "/board/list";
    }

    @GetMapping("/write")
    public String insBoard() {
        return "/board/write";
    }

    private String getBoardTitle(int category) {
        if (category == 0) {
            return null;
        } else {
            String categoryToString = null;

            switch (category) {
                case 1 -> categoryToString = BoardEnum.NOTICE.getTitle();
                case 2 -> categoryToString = BoardEnum.MUSIC_RECOMMEND.getTitle();
                case 3 -> categoryToString = BoardEnum.FREE.getTitle();
            }
            return categoryToString;
        }
    }
}
