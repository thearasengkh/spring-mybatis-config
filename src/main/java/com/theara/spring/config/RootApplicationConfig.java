package com.theara.spring.config;

import com.theara.spring.model.MData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

@Configuration
//@ComponentScan(basePackages = { "com.theara.spring.service" })
public class RootApplicationConfig {

    @Bean(name = "beanFromRootContext")
    public MData beanFromRootContext() {
        MData bean = new MData();
        bean.setString("whoAmI", "I'm from Root App Context");
        return bean;
    }

}
