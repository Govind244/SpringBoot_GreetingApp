package com.GreetingApp.GreetingApp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage() {
        return "Hello, World from service layer";
    }
}
