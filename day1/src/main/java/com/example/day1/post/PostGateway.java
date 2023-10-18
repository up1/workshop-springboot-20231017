package com.example.day1.post;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {

    private final RestTemplate restTemplate;

    @Value("${post.url}")
    private final String host;

    public PostGateway(RestTemplate restTemplate, String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    public Optional<PostResponse> getDataById(int id) {
        String url = host + "/posts/" + id;
        try {
            PostResponse response = restTemplate.getForObject(url, PostResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
