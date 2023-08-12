package com.librarySystem.RestAPI.Service.impl;

import com.librarySystem.RestAPI.Repository.UserRepository;
import com.librarySystem.RestAPI.Service.UserService;
import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return (User) userRepository.save(user);
        } else {
            return existingUser;
        }
    }

    public ResponseMessageBody getUserByName(String name){
        User existingUser = userRepository.findByName(name);
        if (existingUser == null) {
            return new ResponseMessageBody("User is not registered.");
        } else {
            return new ResponseMessageBody(existingUser);
        }
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);
        if(user != null) {
            if(passwordEncoder.matches(password, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
