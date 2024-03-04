package com.project.youtubeplaylistrecommend.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class MyAuthentication {
    public static MyUserDetails myUserDetails() {
        return (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}