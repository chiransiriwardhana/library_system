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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {

        // PasswordEncoder bCrptPasswordEncoder = springSecurityConfig.getEncoder();
        User existingUser = userRepository.findByName(user.getName());
        if (existingUser == null) {
            return (User) userRepository.save(user);
        } else {
            return existingUser;
        }
    }

    public ResponseMessageBody getUserByName(String name){
        System.out.println("name "+name);
        User existingUser = userRepository.findByName(name);

        if (existingUser == null) {
            System.out.println("no user");
            return new ResponseMessageBody("User is not registered.");
        } else {
            System.out.println("exist user");
            return new ResponseMessageBody(existingUser);
        }
    }
}
