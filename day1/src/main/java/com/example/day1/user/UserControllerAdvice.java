package com.example.day1.user;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(RequestForGetUserByIdException.class)
    public MyErrorResponse invalidInput(Exception e) {
        return new MyErrorResponse(10000, "Input invalid");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public MyErrorResponse userNotFound(Exception e) {
        return new MyErrorResponse(404, e.getMessage());
    }

}
