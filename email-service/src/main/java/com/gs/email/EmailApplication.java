package com.gs.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by schellamuthu on 12/10/18.
 */
@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class,"--spring.application.name=email-service",
                "--server.port=8802"
        );
    }

}
