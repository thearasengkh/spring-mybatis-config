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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", makeDummyUserInfo() );
        modelAndView.setViewName("jsonView");
        return modelAndView;
    }

    @RequestMapping(value = "/first-xml-view-resolver", method = RequestMethod.GET)
    public ModelAndView jSPViewByXmlViewResolver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("firstXmlResolverWelcomeView");
        return modelAndView;
    }

    @RequestMapping(value = "/second-xml-view-resolver", method = RequestMethod.GET)
    public ModelAndView jsonViewByXmlViewResolver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", makeDummyUserInfo() );
        modelAndView.setViewName("secondXmlResolverWelcomeView");
        return modelAndView;
    }

    private MData makeDummyUserInfo() {
        MData jsonObj = new MData();
        jsonObj.setString("name", "DARA SOMNANG");
        jsonObj.setString("job","Software Engineer");
        return jsonObj;
    }

}
