package com.greetingapp.greetpeople.service;

import com.greetingapp.greetpeople.dto.AuthUserDTO;
import com.greetingapp.greetpeople.dto.LoginDTO;
import com.greetingapp.greetpeople.model.AuthUser;
import com.greetingapp.greetpeople.repository.AuthUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    private final AuthUserRepository authUserRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthUserServiceImpl(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public String registerUser(AuthUserDTO authUserDTO) {
        Optional<AuthUser> existingUser = authUserRepository.findByEmail(authUserDTO.getEmail());
        if (existingUser.isPresent()) {
            return "Email is already in use.";
        }

        AuthUser user = new AuthUser();
        user.setFirstName(authUserDTO.getFirstName());
        user.setLastName(authUserDTO.getLastName());
        user.setEmail(authUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(authUserDTO.getPassword())); // Password Hashing

        authUserRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        Optional<AuthUser> user = authUserRepository.findByEmail(loginDTO.getEmail());
        if (user.isEmpty() || !passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword())) {
            return "Invalid email or password.";
        }
        return "Login successful!";
    }
}
