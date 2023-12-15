package com.oakscode.usermanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
//@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}


}
