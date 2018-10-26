package com.example.login.repository;

import com.example.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Personnel,String> {

    Personnel findByUsername(String username);

    Personnel findByUsernameAndPassword(String username, String password);
}
