package com.example.day1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Success to get data from database with id =1")
    public void case01(){
        // Arrange
        MyUser u1 = new MyUser(1, "Somkiat");
        userRepository.save(u1);
        // Act
        Optional<MyUser> result = userRepository.findById(1);
        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Fail to get data from database with id =1")
    public void case02(){
        // Act
        Optional<MyUser> result = userRepository.findById(1);
        // Assert
        assertFalse(result.isPresent());
    }

}