package com.librarySystem.RestAPI.Service;

import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    User addUser(User user);

    ResponseMessageBody getUserByName(String name);

}
