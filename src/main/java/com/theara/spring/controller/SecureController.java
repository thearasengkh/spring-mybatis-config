package com.theara.spring.controller;

import com.theara.spring.model.MData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Theara Seng
 * created on Apr 12, 2020
 */

@Controller
@RequestMapping("/secure")
public class SecureController {

    @GetMapping
    public String index() {
        return "security/index";
    }

    @GetMapping("/secret-info")
    @ResponseBody
    public MData secretInfo() {
        MData info = new MData();
        info.setString("message", "You're viewing super secret info.");
        return info;
    }

}
