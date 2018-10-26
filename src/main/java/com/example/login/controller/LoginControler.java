package com.example.login.controller;

import com.example.login.entities.Personnel;
import com.example.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class LoginControler {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login")
    public String enterLogin() {
        return "login";
    }

    @RequestMapping("/{type}")
    public String enterView(@PathVariable String type) {
        return type;
    }

    @RequestMapping("/register")
    public String enters() {
        return "register";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map login(Personnel personnel) {

        String username = personnel.getUsername();
        String password = personnel.getPassword();

        Map<String, Object> map = new HashMap<>();
        Personnel personnel1 = loginService.findByUsername(username);
        if (personnel1 == null) {
            map.put("errorMessage", "该用户不存在");
            return map;
        } else {
            Personnel personnel2 = loginService.findByUsernameAndPassword(username, password);
            if (personnel2 == null) {
                map.put("errorMessage", "密码错误");
                return map;
            } else {
                if ("0".equals(personnel2.getValid())) {
                    if ("0".equals(personnel2.getFlag())) {
                        map.put("type", "index");
                        return map;
                    } else {
                        map.put("type", "administrator");
                        return map;
                    }
                } else {
                    map.put("errorMessage", "该账号无效，请联系管理员");
                    return map;
                }
            }
        }

    }
}
