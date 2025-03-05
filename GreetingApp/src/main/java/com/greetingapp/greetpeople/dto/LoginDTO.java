package com.greetingapp.greetpeople.dto;

import jakarta.validation.constraints.*;

public class LoginDTO {

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    public LoginDTO() {}

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
