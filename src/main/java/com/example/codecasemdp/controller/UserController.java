package com.example.codecasemdp.controller;

import com.example.codecasemdp.entity.User;
import com.example.codecasemdp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User request){
        return userService.addUser(request);
    }

    @GetMapping(value = "/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
