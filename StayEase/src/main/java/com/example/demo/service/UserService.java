package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.utility.FinalResponse;
import com.example.demo.utility.UserResponse;

import java.util.Optional;

public interface UserService {

    FinalResponse createUser();

    UserResponse registerUser(UserDto userDto);

    Optional<User> findByEmail(String email);

    UserResponse userLogin(UserDto user) throws Exception;
}
