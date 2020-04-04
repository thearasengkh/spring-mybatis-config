package com.theara.spring.controller;

import com.theara.spring.model.MData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

@Controller
@RequestMapping("/test/")
public class WelcomeController {

    @RequestMapping(value = "/bean-name-view-resolver", method = RequestMethod.GET)
    public ModelAndView jsonView() {

        MData jsonObj = new MData();
        jsonObj.setString("name", "DARA SOMNANG");
        jsonObj.setString("job","Software Engineer");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", jsonObj );
        modelAndView.setViewName("jsonView");
        return modelAndView;
    }

}
