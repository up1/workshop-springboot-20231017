package com.example.day1.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping(value = "/user/{id}")
    public UserResponse getUserByID(@PathVariable String id) {
        // Validate input
        validateInput(id);

        // TODO next
        // Return response :: success only
        return new UserResponse(1, "Somkiat");
    }

    private void validateInput(String id) {
        if("2".equals(id)) {
            throw new RequestForGetUserByIdException(id);
        }
    }

}
