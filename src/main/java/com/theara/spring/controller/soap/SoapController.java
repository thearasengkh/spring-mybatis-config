package com.theara.spring.controller.soap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theara.spring.model.cbc.REQUEST;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @RequestMapping(value ="/soap/api", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(@RequestBody REQUEST request, @RequestHeader MultiValueMap<String, String> headers, Model model) throws Exception {

        this.printHeader( headers );

        String referenceNo = request.getMESSAGE().getENQUIRY().getENQUIRY_REFERENCE();
        model.addAttribute("referenceNo", referenceNo);

//        return "mock-up-response";
//        return "success-response";
//        return "standard-report";
        return "standard-with-guarantee-report";
//        return "lite-report";
    }

    @RequestMapping(value ="/soap/api/get-bill-info", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public String getBillInfo(@RequestHeader MultiValueMap<String, String> headers, Model model) throws Exception {

        this.printHeader( headers );

        if (headers.getFirst("soapaction").equals("http://119.82.253.240/GetBillInfo")) {
            return "ppwsa/bill-info";
        }

        return "ppwsa/update-bill-info";
    }

    private void printHeader(MultiValueMap<String, String> headers) throws Exception {

        String headerJsonValue = new ObjectMapper().writeValueAsString(headers);
        System.out.println(headerJsonValue);

    }

}
