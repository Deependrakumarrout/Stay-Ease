package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utility.FinalResponse;
import com.example.demo.utility.JwtUtil;
import com.example.demo.utility.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;


//    @Autowired
//    private UserDetailsService userDetailsService;


    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserDto user) {
       return userService.registerUser(user);

    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody UserDto user) throws Exception {
       return userService.userLogin(user);
//        return null;
    }


    @GetMapping("/create-user")
    public FinalResponse createUser() {
        return userService.createUser();
    }

}

//http://localhost:8088/api/crio/do/user/create-user
