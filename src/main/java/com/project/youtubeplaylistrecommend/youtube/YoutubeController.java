package com.project.youtubeplaylistrecommend.youtube;

import com.project.youtubeplaylistrecommend.youtube.model.YoutubeInfoGetVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class YoutubeController {
    private final YoutubeService youtubeService;

    @GetMapping("/search")
    public String searchForm() {
        return "/youtube-search-test";
    }

    @GetMapping("/search-result/{keyword}")
    public String search(@PathVariable String keyword, Model model) throws Exception {
        // 116번 이상 호출 시 일일 할당량 소진으로 에러 발생
        try {
            List<YoutubeInfoGetVo> list = youtubeService.searchVideo(keyword);
            model.addAttribute("list", list);
        } catch (Exception e) {
            throw new Exception();
        }
        return "/youtube-search-test";
    }
}
