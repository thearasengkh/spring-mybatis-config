package com.theara.spring.config;

import com.theara.spring.model.MData;
import org.springframework.context.annotation.Bean;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

public class RootApplicationConfig {

    @Bean(name = "beanFromRootContext")
    public MData beanFromRootContext() {
        MData bean = new MData();
        bean.setString("whoAmI", "I'm from Root App Context");
        return bean;
    }

}
