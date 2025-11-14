package com.teamproject.busbooking.data;

import com.teamproject.busbooking.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private final List<User> users = new ArrayList<>();

    private UserRepository() {

        //default user for testing
        users.add(new User("1", "eswar", "eswar", "eswar@example.com", "USER"));
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
