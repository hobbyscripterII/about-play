package com.project.youtubeplaylistrecommend.security;

import com.project.youtubeplaylistrecommend.user.UserRepository;
import com.project.youtubeplaylistrecommend.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        MyUserDetails myUserDetails = MyUserDetails
                .builder()
                .iuser(userEntity.getIuser())
                .kakaoId(userEntity.getKakaoId())
                .upw(userEntity.getPwd())
                .nm(userEntity.getName())
                .role(userEntity.getRole())
                .build();

        // 추후 카카오 아이디 로그인 추가

        if (myUserDetails != null) {
            return myUserDetails;
        } else {
            throw new UsernameNotFoundException("자격 증명에 실패하였습니다.");
        }
    }
}