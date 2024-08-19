package com.example.demo.serviceImpl;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utility.FinalResponse;
import com.example.demo.utility.JwtUtil;
import com.example.demo.utility.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    @Lazy
//     private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

//    @Autowired
//    private PasswordEncoder passwordEncoder; // Use PasswordEncoder interface

    @Override
    public UserResponse registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
      //  user.setPassword(passwordEncoder.encode(userDto.getPassword())); // Use passwordEncoder here
        userRepository.save(user);
     //   String token = jwtUtil.generateToken(userDto.getEmail());

        UserResponse response = new UserResponse();
        response.setMessage("User Register Successfully");
        response.setStatus(true);
        response.setToken("NA");
        response.setObject(user);

        return response;
    }

    @Override
    public FinalResponse createUser() {
        System.out.println("hello world");
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public UserResponse userLogin(UserDto user) throws Exception {
       /*
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        }catch (AuthenticationException e) {
            throw new Exception("Invalid credentials");
        }
        Optional<User> userDetails = userRepository.findByEmail(user.getEmail());
        String token = jwtUtil.generateToken(userDetails.get().getEmail());

        UserResponse response = new UserResponse();
        response.setMessage("User Login Successful");
        response.setStatus(true);
        response.setToken(token);
        response.setObject(userDetails.get());

        return response;

        */

        return null;
    }


/*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }



 */

    /*
    @Autowired
    private UserRepository userRepository;


    @Autowired(required = true)
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
      //  user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);

    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public FinalResponse createUser() {
        System.out.println("hello world");
        return null;
    }


     */
}
