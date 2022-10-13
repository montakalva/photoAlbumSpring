package com.example.photoalbumspring.controllers;

import com.example.photoalbumspring.entities.User;
import com.example.photoalbumspring.repositories.UserRepository;
import com.example.photoalbumspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.attribute.Attribute;
import java.util.ArrayList;

@Controller
public class UserController {

    UserService userService;
    UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping ("/register")
    public String runRegisterPage(){
    return "register";
    }

    @PostMapping ("/register")
    public String handleUserRegistration(User user){
    try{
        this.userService.createUser(user);
    } catch (Exception exception){
        exception.getMessage();
    }
        return "login";
    }

    @GetMapping ("/login")
    public String runLoginPage() { return "login";}

    @PostMapping ("/login")
    public String handleUserLogin(User user) {
        try{
            User loggedInUser = userService.verifyUser(user);
        } catch (Exception exception){
            exception.getMessage();
        }
        return "menu";
    }

    @GetMapping("/users")
    public String runUsersPage(Model model){
        ArrayList<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
