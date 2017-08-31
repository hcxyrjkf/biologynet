package com.hcxy.controller;

import com.hcxy.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Sjming
 * 2017-08-31 15:59
 */
@RestController
@RequestMapping(value = "/api")
public class AuthController {

    @Resource
    private AuthService authService;

    @PutMapping(value = "/login")
    public Object login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpSession session) {
        return authService.login(username, password, session);
    }

    @PostMapping(value = "/register")
    public Object resigter(@RequestParam("username") String username,
                         @RequestParam("password") String password) {

        return authService.register(username, password);
    }

    @DeleteMapping(value = "/logout")
    public Object logout(HttpSession session) {
        return authService.logout(session);
    }
}
