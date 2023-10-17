package com.example.day1.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse{
	private int id;
	private String name;
}