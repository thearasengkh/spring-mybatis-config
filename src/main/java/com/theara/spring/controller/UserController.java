package com.theara.spring.controller;

import com.theara.spring.model.User;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> getAllUsers() {
        return userService.selectAll();
    }

    @RequestMapping("/{email}")
    public User getUserInfo(@PathVariable String email) {
        return userService.getUserInfoByEmail(email);
    }

}
