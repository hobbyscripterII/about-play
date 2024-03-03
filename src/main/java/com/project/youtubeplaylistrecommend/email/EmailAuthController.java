package com.project.youtubeplaylistrecommend.email;

import com.project.youtubeplaylistrecommend.common.Utils;
import com.project.youtubeplaylistrecommend.email.model.EmailAuthCodeGetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.project.youtubeplaylistrecommend.common.Const.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailAuthController {
    private final EmailAuthService emailAuthService;

    @GetMapping("/send")
    @ResponseBody
    public int emailSend(@RequestParam(name = "email") String email) {
        int check = emailAuthService.emailCheck(email); // 이메일 중복여부 체크
        if (Utils.isNull(check)) {
            return DUPLICATION;
        } else {
            int send = emailAuthService.emailSend(email); // 이메일 발송
            return Utils.isNotNull(send) ? SUCCESS : FAIL;
        }
    }

    @PostMapping("/check")
    @ResponseBody
    public int emailAuthCodeCheck(@RequestBody EmailAuthCodeGetDto dto) {
        return emailAuthService.emailAuthCodeCheck(dto);
    }
}
