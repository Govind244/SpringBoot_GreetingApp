package com.greetingapp.greetpeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.greetingapp.greetpeople")
public class GreetingAppApplication {

    public static void main(String[] args)   {
        SpringApplication.run(GreetingAppApplication.class, args);
    }

}
