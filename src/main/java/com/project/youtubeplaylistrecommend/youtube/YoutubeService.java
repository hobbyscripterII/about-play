package com.project.youtubeplaylistrecommend.youtube;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.project.youtubeplaylistrecommend.youtube.model.YoutubeInfoGetVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class YoutubeService {
    @Value("${youtube.apikey}")
    private String apiKey;
    private String videoUrl = "https://www.youtube.com/watch?v=";
    private String thumbnailPrefixUrl = "http://img.youtube.com/vi/";
    private String thumbnailSuffixUrl = "/hqdefault.jpg";

    // youtube client 생성
    public List<YoutubeInfoGetVo> searchVideo(String keyword) throws IOException {
        JsonFactory jsonFactory = new JacksonFactory();

        YouTube youTube = new YouTube.Builder(
                new NetHttpTransport(),
                jsonFactory,
                request -> {}
        ).build();

        // 요청 객체 생성
        YouTube.Search.List search = youTube.search().list("id,snippet");

        search.setKey(apiKey);
        search.setQ(keyword);

        SearchListResponse response = search.execute();
        List<SearchResult> list = response.getItems();

        if(list.size() != 0) {
            return list.stream()
                    .map(item -> YoutubeInfoGetVo.builder()
                            .title(item.getSnippet().getTitle())
                            .videoUrl(videoUrl + item.getId().getVideoId())
                            .thumbnailUrl(thumbnailPrefixUrl + item.getId().getVideoId() + thumbnailSuffixUrl)
                            .description(item.getSnippet().getDescription())
                            .build())
                    .toList();
        }

        return null;
    }
}
