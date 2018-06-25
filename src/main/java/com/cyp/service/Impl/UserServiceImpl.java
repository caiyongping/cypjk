package com.cyp.service.Impl;

import com.cyp.dao.UserDao;
import com.cyp.entity.User;
import com.cyp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CYP on 2018/6/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }
    @Override
    public void regist(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String userName, String password) {

        User user = userDao.findByUsername(userName);
        if(user != null && user.getPassword().equals(password)){

            return user;
        }
        return null;    }

}
