package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// http://www.techforumist.com/spring-boot-basic-security/
@RestController
public class DemoController {
    @GetMapping("/hi")
    public String sayHi(){
       return "Hello World";
    }
}
