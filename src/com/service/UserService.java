package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthOptionPaneUI;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //根据用户名和密码匹配User
    public boolean hasMatchUser(String userName, String password)
    {
        int matchCount = userDao.getMatchCount(userName,password);
        System.out.println("匹配个数"+matchCount);
        return matchCount>0;
    }

    //登陆成功后更新用户的最后登录信息
    public void loginSuccess(User user)
    {
        userDao.updateUser(user);
    }

    public User findUserByName(String userName)
    {
        return userDao.findUserByUserName(userName);
    }
    //注册用户
    public void insertNewUser(User user)
    {
        userDao.createNewUser(user);
    }
}
