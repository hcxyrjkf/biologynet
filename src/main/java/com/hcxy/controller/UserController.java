package com.hcxy.controller;

import com.hcxy.entity.User;
import com.hcxy.repository.UserRepository;
import com.hcxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sjming
 * @time 2017-08-30 23:52
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> userList() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User userAdd(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        return userService.add(username, password);
    }
}
