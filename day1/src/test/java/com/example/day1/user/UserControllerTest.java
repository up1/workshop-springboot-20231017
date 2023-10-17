package com.example.day1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Success for get user by id = 1")
    void getUserByID() {
        // Act
        UserResponse response = testRestTemplate.getForObject(
                "/api/v1/user/1", UserResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("Somkiat", response.getName());
    }
}