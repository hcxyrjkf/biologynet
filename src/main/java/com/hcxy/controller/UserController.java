package com.hcxy.controller;

import com.hcxy.entity.User;
import com.hcxy.repository.UserRepository;
import com.hcxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public Object userList(HttpSession session) {
        return userService.findAll(session);
    }

    @PostMapping(value = "/users")
    public Object userAdd(User user,
                        HttpSession session) {
        return userService.save(user, session);
    }

    @DeleteMapping(value = "/users/{id}")
    public Object userDelete(@PathVariable("id") Integer id,
                             HttpSession session) {
        return userService.delete(id, session);
    }
}
