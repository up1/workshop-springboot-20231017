package com.example.day1.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse get(int id) {
//        return new UserResponse(1, "Somkiat");
        Optional<MyUser> result = userRepository.findById(id);
        if(result.isPresent()) {
            return new UserResponse(result.get().getId(),
                    result.get().getName());
        }
        throw new UserNotFoundException("User id=" + id + " not found");
    }

}
