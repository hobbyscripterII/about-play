package com.project.youtubeplaylistrecommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YoutubePlaylistRecommendApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoutubePlaylistRecommendApplication.class, args);
    }
}
