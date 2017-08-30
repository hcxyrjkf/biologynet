package com.hcxy.service;

import com.hcxy.entity.User;
import com.hcxy.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sjming
 * @time 2017-08-31 00:23
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

}
