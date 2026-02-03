package com.example.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Mapping cho localhost:8080/
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Mapping cho localhost:8080/home
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}

