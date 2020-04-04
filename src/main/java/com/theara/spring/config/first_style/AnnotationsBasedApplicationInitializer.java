package com.theara.spring.config.first_style;

import com.theara.spring.config.RootApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

public class AnnotationsBasedApplicationInitializer /*implements WebApplicationInitializer*/ {

    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(RootApplicationConfig.class);

        servletContext.addListener(new ContextLoaderListener(rootAppContext));

    }

}
