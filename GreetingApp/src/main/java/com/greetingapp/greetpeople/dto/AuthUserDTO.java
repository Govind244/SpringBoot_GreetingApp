package com.greetingapp.greetpeople.dto;

import jakarta.validation.constraints.*;

public class AuthUserDTO {

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "First letter must be uppercase")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "First letter must be uppercase")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()-+=]).{8,}$",
            message = "Password must be at least 8 characters long, contain 1 uppercase letter, 1 number, and 1 special character"
    )
    private String password;

    public AuthUserDTO() {}

    public AuthUserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
