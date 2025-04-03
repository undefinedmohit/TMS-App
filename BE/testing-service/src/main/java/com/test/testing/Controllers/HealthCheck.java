package com.test.testing.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-check")
public class HealthCheck {
    
    @GetMapping
    String healthCheck()
    {
        return "I'm up!!";
    }
}
