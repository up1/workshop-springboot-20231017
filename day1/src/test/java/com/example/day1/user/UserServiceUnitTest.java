package com.example.day1.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void case01() {
        // Arrange
        MyUser mock = new MyUser(1, "Mock");
        when(userRepository.findById(1))
                .thenReturn(Optional.of(mock));
        UserService service = new UserService(userRepository);
        // Act
        UserResponse result = service.get(1);
        // Assert
        assertNotNull(result);
        assertEquals("Mock", result.getName());
    }
}