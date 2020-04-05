package com.theara.spring.config.second_style;

import com.theara.spring.config.MvcServletConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Theara Seng
 * created on Apr 05, 2020
 */

public class AnnotationBasedServletApplicationContextInitializer extends AbstractDispatcherServletInitializer {

    //@Override
    protected WebApplicationContext createServletApplicationContext() {

        AnnotationConfigWebApplicationContext mvcServletContext = new AnnotationConfigWebApplicationContext();
        mvcServletContext.register(MvcServletConfig.class);
        return mvcServletContext;

    }

    //@Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //@Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
