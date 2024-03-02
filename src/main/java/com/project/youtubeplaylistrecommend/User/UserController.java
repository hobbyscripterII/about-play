package com.project.youtubeplaylistrecommend.User;

import com.project.youtubeplaylistrecommend.User.model.UserSignInDto;
import com.project.youtubeplaylistrecommend.User.model.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

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
            if (bindingResult.hasErrors()) {
                return "/sign-up";
            } else {
                return userService.signUp(dto) == 1 ? "/home" : "/sign-up";
            }
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
