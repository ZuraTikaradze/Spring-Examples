package com.github.zuratikaradze.security.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//https://www.baeldung.com/spring-security-method-security

@RestController
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "Hi User";
    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String hi2() {
        return "Hi Admin";
    }
}
