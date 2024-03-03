package com.project.youtubeplaylistrecommend.youtube;

import com.project.youtubeplaylistrecommend.youtube.model.YoutubeInfoGetVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class YoutubeController {
    private final YoutubeService youtubeService;

    @GetMapping("/search")
    public String search() {
        return "/youtube-search-test";
    }

    @GetMapping("/search/{keyword}")
    public String search(@PathVariable(name = "keyword") String keyword, Model model) throws Exception {
        // 116번 이상 호출 시 일일 할당량 소진으로 에러 발생
        try {
            List<YoutubeInfoGetVo> list = youtubeService.searchVideo(keyword);
            log.info("list = {}", list);
            model.addAttribute("list", list);
        } catch (Exception e) {
            throw new Exception();
        }
        return "/youtube-search-test";
    }
}
