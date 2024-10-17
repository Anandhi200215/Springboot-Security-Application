package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.DAO.UserCredentiailRepository;
import com.example.SpringSecurity.Entity.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {
    @Autowired
    UserCredentiailRepository userCredentiailRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;

    public UserCredential register(UserCredential user){
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userCredentiailRepository.saveAndFlush(user);
    }
//    public  boolean  verifyToken(String token){
//        jwtService.validateToken(token);
//        return true;
//    }
    public String generateToken(String name){
        return jwtService.generateToken(name);
    }

}
