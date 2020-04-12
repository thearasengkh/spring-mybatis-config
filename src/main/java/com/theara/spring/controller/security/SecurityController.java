package com.theara.spring.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Theara Seng
 * created on Apr 12, 2020
 */

@Controller
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/login")
    public String loginForm() {
        return "security/login";
    }

}
