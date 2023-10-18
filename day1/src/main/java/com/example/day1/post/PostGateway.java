package com.example.day1.post;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PostGateway {

    private final RestTemplate restTemplate;
    private final Environment env;

    public Optional<PostResponse> getDataById(int id) {
        String host = env.getProperty("post.url");
        String url = host + "/posts/" + id;
        try {
            PostResponse response = restTemplate.getForObject(url, PostResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
