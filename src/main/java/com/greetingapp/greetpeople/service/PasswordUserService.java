package com.greetingapp.greetpeople.service;

import com.greetingapp.greetpeople.dto.ForgotPasswordDTO;
import com.greetingapp.greetpeople.dto.ResetPasswordDTO;
import com.greetingapp.greetpeople.model.AuthUser;
import com.greetingapp.greetpeople.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasswordUserService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private EmailService emailService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Handle Forgot Password Request
    public String handleForgotPassword(String email, ForgotPasswordDTO forgotPasswordDTO) {
        Optional<AuthUser> optionalUser = authUserRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return "Sorry! We cannot find the user email: " + email;
        }

        AuthUser user = optionalUser.get();
        user.setPassword(passwordEncoder.encode(forgotPasswordDTO.getPassword())); // Hash new password
        authUserRepository.save(user);

        // Send email notification
        emailService.sendEmail(email, "Password Reset", "Your password has been updated successfully.");

        return "Password has been changed successfully!";
    }

    // Handle Reset Password Request
    public String handleResetPassword(String email, ResetPasswordDTO resetPasswordDTO) {
        Optional<AuthUser> optionalUser = authUserRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return "User not found with email: " + email;
        }

        AuthUser user = optionalUser.get();
        if (!passwordEncoder.matches(resetPasswordDTO.getCurrentPassword(), user.getPassword())) {
            return "Current password is incorrect!";
        }

        user.setPassword(passwordEncoder.encode(resetPasswordDTO.getNewPassword())); // Hash new password
        authUserRepository.save(user);
        return "Password reset successfully!";
    }
}
