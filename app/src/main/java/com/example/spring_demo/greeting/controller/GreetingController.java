package com.example.spring_demo.greeting.controller;

import com.example.spring_demo.greeting.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rafa Calvo (https://www.rafacalvo.com/)
 * @version 1.0
 * @since 23/02/2023
 */

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(String.format(TEMPLATE, name));
    }

}
