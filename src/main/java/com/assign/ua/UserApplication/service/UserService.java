package com.assign.ua.UserApplication.service;

import com.assign.ua.UserApplication.dao.UserRepository;
import com.assign.ua.UserApplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository ur;


    public List<User> userList() {
        return ur.findAll();

    }

    public User createUser(User user) {
        return ur.save(user);
    }

    public Optional<User> userbyId(int userid) {
        return ur.findById(userid);
    }

    public List<User> deleteUser(int userId) throws EmptyResultDataAccessException {
        ur.deleteById(userId);
        return null;
    }
    public User getUserByName(String name) {
        return ur.findByName(name);
    }
    public Optional<User> modifyUser(User newuser, int id) {
        return ur.findById(id).map(user -> {
            user.setName(newuser.getName());
            user.setEmail(newuser.getEmail());
            return ur.save(user);
        });
    }
}