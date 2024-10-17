package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.UserCredential;
import com.example.SpringSecurity.Service.JwtService;
import com.example.SpringSecurity.Service.UserCredentialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class UserCredentialController {
    @Autowired
    private UserCredentialService userCredentialService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/register")
    public UserCredential registery(@RequestBody UserCredential user) {
        return userCredentialService.register(user);
    }
    @GetMapping("/validate/Token")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        boolean isValid = jwtService.validateToken(token);
        if (isValid) {
            return ResponseEntity.ok("Token is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid.");
        }
    }
//    public boolean validateToken(@RequestParam String token){
//         jwtService.validateToken(token);
//         return true;
//    }

    @PostMapping ("Validate/user")
    public String getToken(@RequestBody UserCredential user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return userCredentialService.generateToken(user.getName());
        } else {
            return null;
        }

    }}


