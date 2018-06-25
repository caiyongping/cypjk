package com.cyp.service;

import com.cyp.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by CYP on 2018/6/5.
 */

public interface UserService {
    public User getUserById(int userId);
    //用户注册
    void regist(User user);
    //用户登录
    User login(String userName,String password);
}
