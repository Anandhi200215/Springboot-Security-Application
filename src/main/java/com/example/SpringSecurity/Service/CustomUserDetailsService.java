package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.DAO.UserCredentiailRepository;
import com.example.SpringSecurity.Entity.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserCredentiailRepository userCredentiailRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<UserCredential> user=userCredentiailRepository.findByName(username);
        return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Not Valid!"));
    }
}
