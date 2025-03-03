package com.GreetingApp.GreetingApp.GreetingController;



import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String getGreeting() {
        return "Hello,world";
    }


}
