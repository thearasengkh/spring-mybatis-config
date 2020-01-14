package com.theara.spring.controller;

import com.theara.spring.model.MData;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/account")
    public MData test() {
        return this.userService.retrieveUserInfo(new MData());
    }

}
