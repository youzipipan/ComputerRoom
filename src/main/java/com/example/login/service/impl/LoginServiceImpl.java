package com.example.login.service.impl;

import com.example.login.entities.Personnel;
import com.example.login.repository.LoginRepository;
import com.example.login.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginRepository loginRepository;

    @Override
    public Personnel findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }

    @Override
    public Personnel findByUsernameAndPassword(String username, String password) {
        return loginRepository.findByUsernameAndPassword(username,password);
    }
}
