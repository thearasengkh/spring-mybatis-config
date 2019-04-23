package com.theara.spring.controller;

import com.theara.spring.model.User;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

@RestController("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getUserInfo() {
        return userService.getUserInfoByEmail("hahaha");
    }

}
