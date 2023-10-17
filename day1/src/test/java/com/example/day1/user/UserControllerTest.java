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

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Success for get user by id = 1")
    void case01() {
        // Arrange => Initial data for test
        MyUser u1 = new MyUser(1, "Somkiat");
        userRepository.save(u1);
        // Act
        UserResponse response = testRestTemplate.getForObject(
                "/api/v1/user/1", UserResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("Somkiat", response.getName());
    }

    @Test
    @DisplayName("Invalid input")
    void case02() {
        // Act
        MyErrorResponse response = testRestTemplate.getForObject(
                "/api/v1/user/2", MyErrorResponse.class);
        // Assert
        assertEquals(10000, response.getCode());
        assertEquals("Input invalid", response.getDescription());
    }
}