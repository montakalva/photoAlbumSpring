package com.example.photoalbumspring.services;

import com.example.photoalbumspring.entities.User;
import com.example.photoalbumspring.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public void createUser(User user) throws Exception {
        this.userRepository.save(user);
    }

    public User verifyUser(User userLoginRequest) throws Exception {
        User userfound = this.userRepository.findUserByUsernameAndPassword(userLoginRequest.getUsername(), userLoginRequest.getPassword());
        return userfound;
    }
}
