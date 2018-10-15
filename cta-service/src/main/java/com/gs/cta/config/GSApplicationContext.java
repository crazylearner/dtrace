package com.gs.cta.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by schellamuthu on 12/10/18.
 */
public class GSApplicationContext implements ApplicationContextAware {
    public static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        GSApplicationContext.applicationContext = applicationContext;
    }


}
