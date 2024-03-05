package com.project.youtubeplaylistrecommend.common;

import com.project.youtubeplaylistrecommend.security.MyAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AuditorAwareConfig implements AuditorAware<Long> {
    // @CreatedBy, @LastModifiedBy 사용 시 구현 필요
    @Override
    public Optional<Long> getCurrentAuditor() {
        long iuser = MyAuthentication.myUserDetails().getIuser();
        if (Utils.isNull(iuser)) {
            return null;
        }
        return Optional.ofNullable(iuser);
    }
}
