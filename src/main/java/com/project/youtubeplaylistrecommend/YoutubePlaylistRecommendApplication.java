package com.project.youtubeplaylistrecommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // jpa 데이터 등록, 변경 시 자동 insert 기능
@SpringBootApplication
public class YoutubePlaylistRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubePlaylistRecommendApplication.class, args);
    }

}
