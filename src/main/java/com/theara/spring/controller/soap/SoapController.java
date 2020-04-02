package com.theara.spring.controller.soap;

import com.theara.spring.model.cbc.REQUEST;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value ="/soap/api", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public String test(@RequestBody REQUEST request, Model model) {

        String referenceNo = request.getMESSAGE().getENQUIRY().getENQUIRY_REFERENCE();
        model.addAttribute("referenceNo", referenceNo);

        return "mock-up-response";
//        return "success-response";
    }

}
