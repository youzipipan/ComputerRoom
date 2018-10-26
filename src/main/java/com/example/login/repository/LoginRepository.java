package com.example.login.repository;

import com.example.login.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Personnel,String> {

    Personnel findByUsername(String username);

    Personnel findByUsernameAndPassword(String username, String password);
}
