package com.authentication.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/public/health-check")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthCheck {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/up")
    String healthCheck() {
        return "I'm Up!";
    }

    @GetMapping("/test-service/health")
    public String getUserById() {
        return restTemplate.getForObject("http://localhost:8080/health-check", String.class);
    }

    @GetMapping("/prime")
    public void primeNumbers()
    {
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(50);
        integers.add(8);
        integers.add(9);
        integers.add(18);

        // integers.stream().filter(x-> x%2 ==2)
        List<Integer> prime = new ArrayList<>();
        for(int i= 0; i< integers.size(); i++)
        {
            if(i%2 ==0)
            {
                prime.add(i);
            }
        }
        System.out.println(prime);

    }


}
