package com.theara.spring.service.impl;

import com.theara.spring.dao.UserDao;
import com.theara.spring.model.User;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfoByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return user;
    }

    @Override
    public List<User> selectAll() {
        return this.userDao.selectAll();
    }

}
