package com.theara.spring.controller.soap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Theara Seng
 * created on Apr 01, 2019
 */

@Controller
public class SoapController {

    private long lastNo = 1427;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String whatever() {
        return "index.jsp";
    }

    @RequestMapping(value ="/soap/api", method = RequestMethod.POST)
    public String test(Model model) {
        model.addAttribute("referenceNo", "2020000" + lastNo++);
        return "success-response.jsp";
    }

}
