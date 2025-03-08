package com.greetingapp.greetpeople.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmailDTO {

    @NotBlank(message = "Recipient email cannot be empty")
    @Email(message = "Invalid email format")
    private String to;

    @NotBlank(message = "Subject cannot be empty")
//    @Size(max = 100, message = "Subject cannot exceed 100 characters")
    private String subject;

    @NotBlank(message = "Email body cannot be empty")
    private String body;

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
