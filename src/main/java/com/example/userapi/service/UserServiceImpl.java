package com.example.userapi.service;

import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new Error("ユーザーが存在しません。");
        } else {
            return optionalUser.get();
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User currentUser = getUser(id);
        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setAddress(user.getAddress());
        return userRepository.save(user);    }

    @Override
    public void deleteUser(Long id) {
        getUser(id);
        userRepository.deleteById(id);
    }
}
