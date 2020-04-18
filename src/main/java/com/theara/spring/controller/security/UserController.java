package com.theara.spring.controller.security;

import com.theara.spring.model.MData;
import com.theara.spring.model.common.UserDto;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Theara Seng
 * created on Apr 15, 2020
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String register(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "thymeleaf-view/security/registration";

    }

    @PostMapping("/new")
    public String register(@Valid @ModelAttribute UserDto user, Model model, Errors errors) {

        System.out.println("Hello world");
        model.addAttribute("user", user);
        return "thymeleaf-view/security/registration";

    }

    @GetMapping("/{email}")
    @ResponseBody
    public UserDto retrieveUserFindEmail(@PathVariable("email") String email) {

        MData ipUserInfo = new MData();
        ipUserInfo.setString("email", email);
        return this.userService.retrieveUserDtoInfo(ipUserInfo);

    }

}
