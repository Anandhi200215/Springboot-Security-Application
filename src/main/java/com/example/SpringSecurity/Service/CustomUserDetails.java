package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.UserCredential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private String name;
    private String password;
    public CustomUserDetails(UserCredential user){
        this.name=user.getName();
        this.password=user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }
    @Override
    public String getPassword(){
        return  password;
    }
    @Override
    public String getUsername(){
        return name;
    }

}
