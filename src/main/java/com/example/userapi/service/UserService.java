package com.example.userapi.service;

import com.example.userapi.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
