package com.theara.spring.config.second_style;

import com.theara.spring.config.RootApplicationConfig;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author Theara Seng
 * created on Apr 05, 2020
 */

public class AnnotationsBasedApplicationInitializer /*extends AbstractContextLoaderInitializer*/ {

    //@Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootApplicationConfig.class);
        return rootContext;
    }

}
