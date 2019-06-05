package com.github.zuratikaradze.security.controller;

import com.github.zuratikaradze.security.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

// ეს კონტროლერი იძახებს /auth  - ს იმიტო რო პირდაპირ სვაგერიდან შევძლო auth ის გამოძახება, სხვაგვარად ვერ დავაკომფიგურირე და დროებით ვორკერაუნდი იყოს.
// იდეაში ისე უნდა შევცვალო რო სვაგერმა წაიკითხოს /auth -ურლი და პირდაპირ იმას მივმართო.
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    Environment environment;

    @PostMapping("/generateJWT")
    public String generateJWT(@RequestBody UserCredentials userCredentials) throws UnknownHostException {
        String url = "http://" + InetAddress.getLoopbackAddress().getHostAddress() + ":" + environment.getProperty("local.server.port") + "/auth";//"http://localhost:8080/auth";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UserCredentials> request = new HttpEntity<>(userCredentials);
        ResponseEntity<UserCredentials> response = restTemplate.exchange(url, HttpMethod.POST, request, UserCredentials.class);
        return response.getHeaders().get("Authorization").toString();
    }
}
