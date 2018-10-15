package com.gs.cta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by schellamuthu on 12/10/18.
 */
@Configuration
public class CtaConfig {

    @Bean
    public GSApplicationContext getContext() {
        return new GSApplicationContext();
    }
}
