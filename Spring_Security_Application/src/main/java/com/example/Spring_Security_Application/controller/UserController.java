package com.example.Spring_Security_Application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {


    @GetMapping("/home")
    @PreAuthorize("hasRole('USER')")
    public String getHome() {
        return "Welcome to home page";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdmin(){
        return "Hi Its Admin";
    }
}