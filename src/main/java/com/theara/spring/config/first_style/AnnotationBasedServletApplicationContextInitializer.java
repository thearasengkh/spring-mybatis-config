package com.theara.spring.config.first_style;

import com.theara.spring.config.MvcServletConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Theara Seng
 * created on Apr 04, 2020
 */

public class AnnotationBasedServletApplicationContextInitializer /*implements WebApplicationInitializer*/ {

    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext mvcServletContext = new AnnotationConfigWebApplicationContext();
        mvcServletContext.register(MvcServletConfig.class);

        ServletRegistration.Dynamic mvc = servletContext.addServlet("mvc", new DispatcherServlet(mvcServletContext));
        mvc.setLoadOnStartup(1);
        mvc.addMapping("/");

    }

}
