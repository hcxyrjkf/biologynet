package com.hcxy.service;

import com.hcxy.entity.ResultMessage;
import com.hcxy.entity.User;
import com.hcxy.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Sjming
 * 2017-08-31 16:12
 */
@Service
public class AuthService {

    @Resource
    private UserRepository userRepository;


    public int checkLoginStatus(HttpSession session) {
        if(session.getAttribute("loginStatus") == null) {
            session.setAttribute("loginStatus", 0);
        }
        return (int)session.getAttribute("loginStatus");
    }

    public ResultMessage login(String username,
                               String password,
                               HttpSession session) {

        ResultMessage resultMessage = new ResultMessage();
        int status = checkLoginStatus(session);
        if(status == 0) {
            List<User> user = userRepository.findByUsername(username);
            if(user.size() > 0 && user.get(0).getPassword().equals(password)) {
                resultMessage.setCode(1);
                resultMessage.setMessage("登录成功");
                session.setAttribute("loginStatus", user.get(0).getLevel());
            } else {
                resultMessage.setCode(0);
                resultMessage.setMessage("账户或密码错误");
            }
        } else {
            resultMessage.setCode(1);
            resultMessage.setMessage("已处于登录状态,请勿多次登录");
        }
        return resultMessage;
    }

    public ResultMessage register(String username,
                                  String password) {

        ResultMessage resultMessage = new ResultMessage();
        List<User> users = userRepository.findByUsername(username);
        if(users.size() == 0) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setLevel(2);
            user.setScore(0);
            userRepository.save(user);
            resultMessage.setCode(1);
            resultMessage.setMessage("注册成功");
        } else {
            resultMessage.setCode(0);
            resultMessage.setMessage("用户名已存在");
        }
        return resultMessage;
    }

    public ResultMessage logout(HttpSession session) {

        ResultMessage resultMessage = new ResultMessage();
        int loginStatus = checkLoginStatus(session);
        if(loginStatus > 0) {
            resultMessage.setCode(1);
            resultMessage.setMessage("注销成功");
            session.setAttribute("loginStatus", 0);
        } else {
            resultMessage.setCode(0);
            resultMessage.setMessage("未处于登录状态,请勿多次注销");
        }
        return resultMessage;
    }
}
