package com.example.SpringSecurity.DAO;

import com.example.SpringSecurity.Entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentiailRepository extends JpaRepository<UserCredential,Integer> {
public Optional<UserCredential> findByName(String name);
}
