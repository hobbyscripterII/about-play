package com.project.youtubeplaylistrecommend.user;

import com.project.youtubeplaylistrecommend.common.Utils;
import com.project.youtubeplaylistrecommend.user.model.UserSignUpDto;
import com.project.youtubeplaylistrecommend.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project.youtubeplaylistrecommend.common.Const.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public int signUp(UserSignUpDto dto) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(dto.getEmail());
            userEntity.setPwd(bCryptPasswordEncoder.encode(dto.getPwd()));
            userEntity.setName(dto.getName());
            userEntity.setRole(DEFAULT_ROLE);
//            userEntity.setPic(dto.getPic());
            userRepository.save(userEntity);
            return SUCCESS;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    public int nameCheck(String name) {
        long result = userRepository.countByName(name);
        return Utils.isNull(result) ? SUCCESS : FAIL;
    }
}
