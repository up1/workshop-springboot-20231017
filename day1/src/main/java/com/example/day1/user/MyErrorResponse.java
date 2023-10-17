package com.example.day1.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyErrorResponse{
	private int code;
	private String description;
}