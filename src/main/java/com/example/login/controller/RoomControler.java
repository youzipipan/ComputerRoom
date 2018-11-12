package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RoomControler {


    @RequestMapping(value="/index1")
    public String index(){

        return "index";

    }

}
