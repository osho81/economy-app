package com.fmellberg.economyapp.config;

// Modify/complete the mock data that are created by data.sql

import com.fmellberg.economyapp.user.DTO.UserDTO;
import com.fmellberg.economyapp.user.User;
import com.fmellberg.economyapp.user.UserRepository;
import com.fmellberg.economyapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MockdataConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, UserService userService) {
        return args -> {
            List<UserDTO> mockUsers = userService.getAllUsers();
            System.out.println("hii");
//            System.out.println(mockUsers);

            for (UserDTO userDto: mockUsers) {
                System.out.println("hi hi");
                userService.updateUser(userDto);
            }
        };
    }

}
