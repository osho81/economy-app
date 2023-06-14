package com.fmellberg.economyapp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        logger.info("Received a request to create a user: {}", userDTO);
        return new ResponseEntity<UserDTO>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        logger.info("Received a request to retrieve all users");
        return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        logger.info("Received a request to retrieve user by ID: {}", id);
        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        logger.info("Received a request to update user with ID: {}", userDTO.getId());
        return new ResponseEntity<UserDTO>(userService.updateUser(userDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        logger.info("Received a request to delete user with ID: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
