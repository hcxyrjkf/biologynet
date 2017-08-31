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
            } else {
                resultMessage.setCode(0);
                resultMessage.setMessage("账户或密码错误");
            }
        } else {
            resultMessage.setCode(1);
            resultMessage.setMessage("已处于登录状态");
        }
        return resultMessage;
    }
}
