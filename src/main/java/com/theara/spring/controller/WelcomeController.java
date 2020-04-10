package com.theara.spring.controller;

import com.theara.spring.controller.abstracts.AbstractMessageSourceController;
import com.theara.spring.model.MData;
import com.theara.spring.model.cbc.ENQUIRY;
import com.theara.spring.model.cbc.MESSAGE;
import com.theara.spring.model.cbc.REQUEST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

@Controller
@RequestMapping("/test/")
public class WelcomeController extends AbstractMessageSourceController {

    @Autowired
    @Qualifier("beanFromRootContext")
    private MData beanFromRootContext;

    @RequestMapping(
            value = "/content-negotiation",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET
    )
    @ResponseBody
    public MData contentNegotiationJson() {
        return makeDummyUserInfo();
    }

    @RequestMapping(
            value = "/content-negotiation",
            produces = {MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.GET
    )
    @ResponseBody
    public REQUEST contentNegotiationXml() {
        return makeDummyXmlData();
    }

    @RequestMapping(value = "/response-body", method = RequestMethod.GET)
    @ResponseBody
    public MData responseBody() {
        return beanFromRootContext;
    }

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

    @RequestMapping(value = "/thymeleaf-view-resolver", method = RequestMethod.GET)
    public ModelAndView thymeleafViewResolver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("thymeleaf-view/index");
        return modelAndView;
    }

    @RequestMapping(value = "/message-source", method = RequestMethod.GET)
    @ResponseBody
    public MData messageSource(Locale locale) {

        String earth = this.messageSource.getMessage("earth", null, locale);
        String hello = this.messageSource.getMessage("hello_x_how_are_you", new String[]{earth}, locale);

        MData output = new MData();
        output.setString("message", hello);
        return output;
    }

    @RequestMapping(value = "/i18n-jsp", method = RequestMethod.GET)
    public String i18nJsp(Locale locale, Model model) {
        String earth = this.messageSource.getMessage("earth", null, "default", locale);
        model.addAttribute("arg", earth);
        return "i18n";
    }

    private MData makeDummyUserInfo() {
        MData jsonObj = new MData();
        jsonObj.setString("name", "DARA SOMNANG");
        jsonObj.setString("job","Software Engineer");
        return jsonObj;
    }

    private REQUEST makeDummyXmlData() {

        REQUEST request = new REQUEST();
        MESSAGE message = new MESSAGE();
        ENQUIRY enquiry = new ENQUIRY();
        enquiry.setENQUIRY_REFERENCE("XXX123456789XXX");
        message.setENQUIRY(enquiry);
        request.setMESSAGE(message);
        return request;

    }

}
