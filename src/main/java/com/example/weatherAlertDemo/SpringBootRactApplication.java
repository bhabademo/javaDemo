package com.example.weatherAlertDemo;

import com.example.weatherAlertDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRactApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRactApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {

	}
}
