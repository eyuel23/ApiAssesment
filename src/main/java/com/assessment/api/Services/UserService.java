package com.assessment.api.Services;

import com.assessment.api.Exception.ResourceNotFoundException;
import com.assessment.api.Model.User;
import com.assessment.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        user.setUsername(userDetails.getUsername());
        user.setGender(userDetails.getGender());
        return userRepository.save(user);
    }
}
