package com.theara.spring.controller.soap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Theara Seng
 * created on Apr 01, 2019
 */

@Controller
public class SoapController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String whatever() {
        return "index.jsp";
    }

    @RequestMapping(value ="/soap/api", method = RequestMethod.POST)
    public String test() {
        return "success-response.jsp";
    }

}
