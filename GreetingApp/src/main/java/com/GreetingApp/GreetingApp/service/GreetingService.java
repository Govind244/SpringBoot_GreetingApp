package com.GreetingApp.GreetingApp.service;

import com.GreetingApp.GreetingApp.model.GreetingMessage;
import com.GreetingApp.GreetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        // Save the message in the database
        GreetingMessage savedMessage = greetingRepository.save(new GreetingMessage(message));
        return "Greeting saved with ID: " + savedMessage.getId();
    }

    public String findGreetingById(Long id) {
        Optional<GreetingMessage> greetingMessage = greetingRepository.findById(id);
        return greetingMessage.map(GreetingMessage::getMessage).orElse("Greeting not found!");
    }

    public List<GreetingMessage> getAllMessages() {
        return greetingRepository.findAll();
    }
}
