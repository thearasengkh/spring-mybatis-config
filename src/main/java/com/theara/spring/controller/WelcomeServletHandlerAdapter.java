package com.theara.spring.controller;

import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Theara Seng
 * created on Apr 02, 2020
 */

public class WelcomeServletHandlerAdapter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(MediaType.TEXT_HTML_VALUE);
        resp.getWriter().write("<p>Hello World</p>");
    }

}
