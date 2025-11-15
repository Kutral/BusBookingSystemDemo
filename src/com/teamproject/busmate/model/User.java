package com.teamproject.busmate.model;

public class User {
    private final String userId;
    private final String username;
    private final String password;
    private final String email;
    private final String userType;

    public User(String userId, String username, String password, String email, String userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }
}

