package com.fmellberg.economyapp.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(int id);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(int id);
}
