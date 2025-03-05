package com.greetingapp.greetpeople.controller;

import com.greetingapp.greetpeople.model.Greeting;
import com.greetingapp.greetpeople.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // get/show the data
    @GetMapping
    public List<Greeting> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        greetings.forEach(greeting -> System.out.println("Fetched Greeting ID: " + greeting.getId()));  // Print IDs
        return greetings;
    }

    // create data
    @PostMapping
    public Greeting createGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        Greeting greeting = greetingService.createGreeting(firstName, lastName);
        System.out.println("Created Greeting ID: " + greeting.getId());  // Print ID to Console
        return greeting;
    }

    // get the data using id
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        System.out.println("Requested Greeting ID: " + id);  // Print Requested ID
        return greetingService.getGreetingById(id);
    }

    // updating data by using id no.
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {
        System.out.println("Updating Greeting ID: " + id);
        System.out.println(greeting);// Print ID Before Update
        return greetingService.updateGreeting(id, greeting);
    }

    // Delete Greeting
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        System.out.println("Deleting Greeting ID: " + id);  // Print ID Before Deletion
        return greetingService.deleteGreeting(id);
    }
}
