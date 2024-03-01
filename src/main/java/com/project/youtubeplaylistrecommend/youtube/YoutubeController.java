package com.project.youtubeplaylistrecommend.youtube;

import com.project.youtubeplaylistrecommend.common.YoutubeApi;
import com.project.youtubeplaylistrecommend.youtube.model.YoutubeInfoGetVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class YoutubeController {
    private final YoutubeApi youtubeApi;

    @GetMapping("/search")
    public String test(@RequestParam(name = "keyword", required = false) String keyword, Model model) throws IOException {
        List<YoutubeInfoGetVo> list = youtubeApi.searchVideo(keyword);
        model.addAttribute("list", list);
        return "/youtube-search-test";
    }
}
