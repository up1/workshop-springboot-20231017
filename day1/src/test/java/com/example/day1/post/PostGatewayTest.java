package com.example.day1.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostGatewayTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    void getDataById() {
        // Act
        Optional<PostResponse> response = postGateway.getDataById(1);
        // Assert
        assertTrue(response.isPresent());
        assertEquals("Mock title", response.get().getTitle());
    }
}