package com.github.zuratikaradze.elk.controller;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;


@RestController
public class ELKController {
    private static final Logger LOG = LogManager.getLogger(ELKController.class.getName());
    @Autowired
    RestTemplate restTemplete;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @RequestMapping(value = "/green")
    public String green() {
        String response = "green";
        LOG.log(Level.INFO, response);
        return response;
    }

    @RequestMapping(value = "/red")
    public String red() {
        String response = "red";

        try {
            throw new ArithmeticException();
        } catch (Exception e) {
           // e.printStackTrace();
            StringWriter stackTrace = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTrace));
            LOG.error("exception " + stackTrace);
        }
        return response;
    }
}
