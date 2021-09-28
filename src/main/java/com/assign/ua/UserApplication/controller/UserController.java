package com.assign.ua.UserApplication.controller;

import com.assign.ua.UserApplication.entity.User;
import com.assign.ua.UserApplication.exception.UserNotFoundException;
import com.assign.ua.UserApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/fetchusers")
    public List<User> fetchperson() {
        return userService.userList();
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }

    @GetMapping("/getbyid/{userId}")
    public Optional<User> user(@PathVariable int userId) {
        return userService.userbyId(userId);
    }

    @GetMapping("/user/{name}")
    public User findProductByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/updateuser/{userId}")
    public Optional<User> updateUser(@RequestBody User userobj, @PathVariable int userId) {
        //User newuser = userService.getUserById(id);
        return userService.modifyUser(userobj, userId);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public List<User> deleteUser(@PathVariable int userId) throws EmptyResultDataAccessException {
        //userService.deleteUser(userId);
        List<User> usr;
        try {
            usr = userService.deleteUser(userId);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException();
//        } catch (EmptyResultDataAccessException e) {
//            throw new EmptyResultDataAccessException(userId);
//        }
        }
        return usr;
    }
}

