package com.example.photoalbumspring.controllers;

import com.example.photoalbumspring.entities.User;
import com.example.photoalbumspring.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;

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
    public String runLoginPage() { return "/login";}

    @PostMapping ("/login")
    public String handleUserLogin(User user) {
        try{
            User loggedInUser = userService.verifyUser(user);
        } catch (Exception exception){
            exception.getMessage();
        }
        return "/menu";
    }



}
