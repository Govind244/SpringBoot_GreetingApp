package com.greetingapp.greetpeople.service;

//import com.greetingapp.greetpeople.model.AuthUser;
//import com.greetingapp.greetpeople.repository.AuthUserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//public class AuthUserService {
//
//    private final AuthUserRepository authUserRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public AuthUserService(AuthUserRepository authUserRepository) {
//        this.authUserRepository = authUserRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    // **User Registration**
//    public String registerUser(AuthUser user) {
//        // Check if email is already registered
//        if (authUserRepository.findByEmail(user.getEmail()).isPresent()) {
//            return "Email is already in use.";
//        }
//
//        // Hash the password before saving
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        // Save user to database
//        authUserRepository.save(user);
//        return "User registered successfully!";
//    }
//
//    // **User Login**
//    public String loginUser(String email, String password) {
//        Optional<AuthUser> userOptional = authUserRepository.findByEmail(email);
//
//        if (userOptional.isEmpty()) {
//            return "Invalid email or password.";
//        }
//
//        AuthUser user = userOptional.get();
//
//        // Check password
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            return "Invalid email or password.";
//        }
//
//        return "Login successful!";
//    }
//}


import com.greetingapp.greetpeople.dto.AuthUserDTO;
import com.greetingapp.greetpeople.dto.LoginDTO;

public interface AuthUserService {
    String registerUser(AuthUserDTO authUserDTO);
    String loginUser(LoginDTO loginDTO);
}


