package com.project.youtubeplaylistrecommend.security;

import com.project.youtubeplaylistrecommend.common.Const;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class MyUserDetails implements UserDetails {
    private long iuser;
    private String email;
    private String kakaoId;
    private String upw;
    private String nm;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(Const.ROLE_PREFIX + role));
        return list;
    }

    @Override
    public String getPassword() {
        return upw;
    }

    @Override
    public String getUsername() {
        return email != null ? email : kakaoId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
