package com.hcxy.service;

import com.hcxy.entity.ResultMessage;
import com.hcxy.entity.User;
import com.hcxy.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sjming
 * @time 2017-08-31 00:23
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private AuthService authService;

    public ResultMessage findAll(HttpSession session) {

        ResultMessage resultMessage = new ResultMessage();
        int loginStatus = authService.checkLoginStatus(session);
        if(loginStatus == 1) {
            resultMessage.setCode(1);
            resultMessage.setMessage("成功获得所有用户信息");
            resultMessage.setContent(userRepository.findAll());
        } else {
            resultMessage.setCode(0);
            resultMessage.setMessage("没有查询权限");
            resultMessage.setContent(null);
        }
        return resultMessage;
    }

    public ResultMessage save(User user,
                     HttpSession session) {

        ResultMessage resultMessage = new ResultMessage();
        int loginStatus = authService.checkLoginStatus(session);
        if(loginStatus == 1) {
            userRepository.save(user);
            resultMessage.setCode(1);
            resultMessage.setMessage("成功添加或更新一个用户");
        } else {
            resultMessage.setCode(0);
            resultMessage.setMessage("没有操作权限");
        }
        return resultMessage;
    }
}
