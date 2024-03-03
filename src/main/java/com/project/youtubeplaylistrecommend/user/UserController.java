package com.project.youtubeplaylistrecommend.user;

import com.project.youtubeplaylistrecommend.common.Utils;
import com.project.youtubeplaylistrecommend.email.EmailAuthService;
import com.project.youtubeplaylistrecommend.user.model.UserSignInDto;
import com.project.youtubeplaylistrecommend.user.model.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.project.youtubeplaylistrecommend.common.Const.SUCCESS;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final EmailAuthService emailAuthService;

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("dto", new UserSignInDto());
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("dto", new UserSignUpDto());
        return "/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@Validated @ModelAttribute(name = "dto") UserSignUpDto dto, BindingResult bindingResult) {
        try {
            if (Utils.isNull(dto.getCode())) {
                bindingResult.addError(new FieldError("dto", "code", "이메일 중복 확인을 하지않으셨습니다."));
            }

            if (bindingResult.hasErrors()) {
                return "/sign-up";
            } else {
                int nameCheckResult = userService.nameCheck(dto.getName());
                int emailAuthCheckResult = emailAuthService.emailAuthCheck(dto.getEmail());

                if (Utils.isNull(nameCheckResult)) {
                    bindingResult.addError(new FieldError("dto", "name", "중복된 닉네임입니다. 다른 닉네임을 사용해주세요."));
                }

                if (Utils.isNull(emailAuthCheckResult)) {
                    bindingResult.addError(new FieldError("dto", "email", "이메일 중복 확인을 하지않으셨습니다."));
                }

                if (bindingResult.hasErrors()) {
                    return "/sign-up";
                } else {
                    int signUpResult = userService.signUp(dto);
                    if (Utils.isNotNull(signUpResult)) {
                        return "/sign-up-success";
                    }
                }
                return "/sign-up";
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    @GetMapping("/name-check")
    @ResponseBody
    public int nameCheck(@RequestParam(name = "name") String name) {
        return userService.nameCheck(name);
    }
}
