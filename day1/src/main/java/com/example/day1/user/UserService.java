package com.example.day1.user;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse get(int id) {
        userRepository.findById(id);
        Optional<MyUser> result = userRepository.findById(id);
        if(result.isPresent()) {
            return new UserResponse(result.get().getId(),
                    result.get().getName());
        }
        throw new UserNotFoundException("User id=" + id + " not found");
    }

    public void process(){
        step1();
        step2();
    }

    @Transactional
    public void step1() {
        userRepository.findById(id);
        userRepository.findById(id);
    }

    public void step2() {
        userRepository.findById(id);
        userRepository.findById(id);
    }

}
