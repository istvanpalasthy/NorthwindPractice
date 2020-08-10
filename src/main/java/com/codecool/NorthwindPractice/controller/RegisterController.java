package com.codecool.NorthwindPractice.controller;

import com.codecool.NorthwindPractice.model.User;
import com.codecool.NorthwindPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String email = map.get("email");
        String password = map.get("password");
        String confirmationPassword = map.get("confirmationPassword");
        userService.add(username, email, password, confirmationPassword);
    }
}
