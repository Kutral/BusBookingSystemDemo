package com.teamproject.busmate.service;

import com.teamproject.busmate.data.UserRepository;
import com.teamproject.busmate.model.User;
import java.util.UUID;

public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User register(String username, String password, String email) {
        if (userRepository.findByUsername(username) != null) {
            return null;
        }
        User newUser = new User(UUID.randomUUID().toString(), username, password, email, "USER");
        userRepository.addUser(newUser);
        return newUser;
    }
}
