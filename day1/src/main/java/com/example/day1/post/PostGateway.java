package com.example.day1.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PostGateway {

    private final RestTemplate restTemplate;

    public Optional<PostResponse> getDataById(int id) {
        String url = "https://jsonplaceholder.cypress.io/posts/" + id;
        try {
            PostResponse response = restTemplate.getForObject(url, PostResponse.class);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
