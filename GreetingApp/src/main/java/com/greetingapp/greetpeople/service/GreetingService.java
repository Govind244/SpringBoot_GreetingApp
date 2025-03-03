package com.greetingapp.greetpeople.service;



import com.greetingapp.greetpeople.model.Greeting;
import com.greetingapp.greetpeople.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting createGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }
//find all
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public Greeting updateGreeting(Long id, Greeting newGreeting) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newGreeting.getMessage());  // Update message
            return greetingRepository.save(greeting);  // Save updated message
        }
        return null;  // If not found, return null
    }

    // **Delete Greeting**
    public String deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return "Greeting deleted successfully!";
        } else {
            return "Greeting not found!";
        }
    }
}
