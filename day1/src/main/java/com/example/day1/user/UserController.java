package com.example.day1.user;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/user/{id}")
    @Observed(name = "getUserByID", contextualName = "getUserByID")
    public UserResponse getUserByID(@PathVariable String id) {
        // Validate input
        validateInput(id);
        // TODO next
        // Return response :: success only
        return userService.get(Integer.parseInt(id));
    }

    public void validateInput(String id) {
        if("2".equals(id)) {
            throw new RequestForGetUserByIdException(id);
        }
    }

    @GetMapping(value = "/tx")
    public String getTx() {
        userService.process();
        return "TX";
    }

}
