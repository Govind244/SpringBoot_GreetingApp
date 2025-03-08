package com.greetingapp.greetpeople.contoller;

import com.greetingapp.greetpeople.dto.AuthUserDTO;
import com.greetingapp.greetpeople.dto.EmailDTO;
import com.greetingapp.greetpeople.dto.LoginDTO;
import com.greetingapp.greetpeople.model.AuthUser;
import com.greetingapp.greetpeople.service.AuthUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.greetingapp.greetpeople.service.EmailService;
import com.greetingapp.greetpeople.dto.ForgotPasswordDTO;
import com.greetingapp.greetpeople.dto.ResetPasswordDTO;
import com.greetingapp.greetpeople.service.PasswordUserService;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthUserService authUserService;
    public AuthUserController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello, Namaste!";
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUser user) {
//        String response = authUserService.registerUser(user);
//        if (response.equals("User registered successfully!")) {
//            return ResponseEntity.status(201).body(response);
//        }
//        return ResponseEntity.badRequest().body(response);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        String response = authUserService.registerUser(authUserDTO);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody AuthUser user) {
//        String response = authUserService.loginUser(user.getEmail(), user.getPassword());
//        if (response.equals("Login successful!")) {
//            return ResponseEntity.ok(response);
//        }
//        return ResponseEntity.status(401).body(response);
//    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        String response = authUserService.loginUser(loginDTO);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/send")
//    public static String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
//        EmailService.sendEmail(to, subject, body);
//        return "Email sent successfully!";
//    }
    @Autowired
    private EmailService emailService;  // Inject EmailService instead of using static call

//    @PostMapping("/send")
//    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
//        emailService.sendEmail(to, subject, body);  // Call instance method
//        return "Email sent successfully!";
//    }
    @PostMapping("/send")
    public String sendEmail(@Valid @RequestBody EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO.getTo(),emailDTO.getSubject(), emailDTO.getBody());  // Call instance method
        return "Email sent successfully!";
    }

    @Autowired
    private PasswordUserService passwordUserService;

    @PutMapping("/forgotPassword/{email}")
    public String forgotPassword(@PathVariable String email, @Valid @RequestBody ForgotPasswordDTO dto) {
        return passwordUserService.handleForgotPassword(email, dto);
    }

    @PutMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email, @Valid @RequestBody ResetPasswordDTO dto) {
        return passwordUserService.handleResetPassword(email, dto);
    }
}
