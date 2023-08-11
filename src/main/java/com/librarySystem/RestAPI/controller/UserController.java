package com.librarySystem.RestAPI.controller;

import com.librarySystem.RestAPI.Service.UserService;
import com.librarySystem.RestAPI.dto.ResponseMessageBody;
import com.librarySystem.RestAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if(users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByName(@PathVariable("userName") String name) {
        try {
            ResponseMessageBody responseMessageBody = userService.getUserByName(name);
            System.out.println(1);
            if(responseMessageBody.getMessage() != null) {
                System.out.println(2);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println(3);
            return new ResponseEntity<>(responseMessageBody.getUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User userObject = userService.addUser(user);
            return new ResponseEntity<>(userObject, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
