package com.fmellberg.economyapp.config;

// Modify/complete the mock data that are created by data.sql

import com.fmellberg.economyapp.user.DTO.UserDTO;
import com.fmellberg.economyapp.user.User;
import com.fmellberg.economyapp.user.UserMapper;
import com.fmellberg.economyapp.user.UserRepository;
import com.fmellberg.economyapp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class MockdataConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, UserService userService) {
        return args -> {
            List<UserDTO> mockUsers = userService.getAllUsers();

            int days = 1; // Used to manipulate fictive time in timestamp/localDateTime hereunder
            int hours = 10;

            for (UserDTO userDto : mockUsers) {
                User tempUser = userRepository.findById(userDto.getId()).get();
                // Add a fictive creation date
                tempUser.setCreatedAt(Timestamp.valueOf(LocalDateTime.now().minusDays(days).minusHours(hours)));
                // Save same user, i.e. update, just adding the creation date (& modification date)
                userRepository.save(tempUser);

                // Next round, fictive time is created a day further away & 2 hours later
                days++;
                hours -= 2;
            }


            // Eventually move all creation of mock data here
            // if so, use data.sql as an additional mock data, when needed
        };
    }

}
