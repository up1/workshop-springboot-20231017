package com.example.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Day1Application.class, args);
		String[] beans = context.getBeanDefinitionNames();
        Arrays.stream(beans).forEach(System.out::println);
		System.out.println("=>>" + context.getBeanDefinitionCount());
	}

}
