package com.example.day1.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse get(int id) {
        return new UserResponse(1, "Somkiat");
    }

}
