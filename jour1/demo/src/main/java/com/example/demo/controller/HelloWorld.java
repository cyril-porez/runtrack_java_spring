package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${profiles.${profiles.active}.message}")
    private String message;

    @GetMapping
    public String hello() {
        return  message;
    }
}
