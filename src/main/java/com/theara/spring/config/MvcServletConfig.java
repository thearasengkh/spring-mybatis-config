package com.theara.spring.config;

import com.theara.spring.controller.WelcomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

public class MvcServletConfig {

    @Bean
    public WelcomeController welcomeController() {
        return new WelcomeController();
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

}
