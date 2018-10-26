package com.example.login.service;

import com.example.login.entities.Personnel;

public interface LoginService {

    Personnel findByUsername(String username);

    Personnel findByUsernameAndPassword(String username, String password);
}
