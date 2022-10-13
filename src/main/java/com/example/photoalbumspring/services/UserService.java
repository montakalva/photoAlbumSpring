package com.example.photoalbumspring.services;

import com.example.photoalbumspring.entities.User;
import com.example.photoalbumspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception {
        this.userRepository.save(user);
    }

    public User verifyUser(User userLoginRequest) throws Exception {
        return this.userRepository.findUserByUsernameAndPassword(userLoginRequest.getUsername(), userLoginRequest.getPassword());
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

}
