package com.theara.spring.config;

import com.theara.spring.controller.WelcomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = { "com.theara.spring.controller" })
public class MvcServletConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WelcomeController welcomeController() {
        return new WelcomeController();
    }

    /*
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }
    */

}
