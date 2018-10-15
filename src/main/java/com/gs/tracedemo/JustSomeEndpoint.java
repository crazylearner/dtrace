package com.gs.tracedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by schellamuthu on 11/10/18.
 */
@RestController
@RequestMapping(value = "/greet", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class JustSomeEndpoint {

    @GetMapping
    public String getGreeting() {
        return "Hello World!";
    }

}
