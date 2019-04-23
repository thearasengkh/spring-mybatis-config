package com.theara.spring.service.impl;

import com.theara.spring.model.User;
import com.theara.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserInfoByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return user;
    }
}
