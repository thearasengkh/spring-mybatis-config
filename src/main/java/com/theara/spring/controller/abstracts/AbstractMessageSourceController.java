package com.theara.spring.controller.abstracts;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/**
 * @author Theara Seng
 * created on Apr 10, 2020
 */

public abstract class AbstractMessageSourceController implements MessageSourceAware {

    protected MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
