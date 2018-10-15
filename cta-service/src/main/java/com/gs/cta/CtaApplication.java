package com.gs.cta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by schellamuthu on 12/10/18.
 */
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "com.gs.cta")
@EntityScan(basePackages = "com.gs.cta")
@EnableJpaRepositories(basePackages = "com.gs.cta")
public class CtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtaApplication.class,"--spring.application.name=cta-service",
                "--server.port=8801"
        );
    }

}
