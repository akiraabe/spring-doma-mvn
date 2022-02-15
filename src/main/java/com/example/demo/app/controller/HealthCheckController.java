package com.example.demo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/custom-health-path")
    public String healthCheck() {
        return "I'm healthy.";
    }
}
