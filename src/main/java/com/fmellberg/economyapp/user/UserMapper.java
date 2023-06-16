package com.fmellberg.economyapp.user;

import com.fmellberg.economyapp.user.DTO.UserDTO;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }


    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        return user;
    }


}
