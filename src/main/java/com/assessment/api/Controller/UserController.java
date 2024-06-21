package com.assessment.api.Controller;

import com.assessment.api.Model.User;
import com.assessment.api.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody User user){
        logger.info("Creating user");
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Getting all users");
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        logger.info("Getting user by id: {}", id);
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        logger.info("User has Successfully been Deleted");
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        logger.info("User has Successfully been updated");
        User updateUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

}
