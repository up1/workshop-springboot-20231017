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
        step1(1);
        step2(1);
    }

    @Transactional(rollbackOn = UserController.class)
    public void step1(int id) {
        userRepository.findById(id); //ok
        userRepository.findById(id); // not ok
    }

    public void step2(int id) {
        userRepository.findById(id);
        userRepository.findById(id);
    }

}
