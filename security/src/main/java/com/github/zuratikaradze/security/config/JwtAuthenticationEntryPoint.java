package com.github.zuratikaradze.security.config;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// აქ შედის იმ შემთხვევაში თუ მომხმარებელი მიაკითხავს ისეთ რესურს რომელზეც არ არის აუტენთიფიცირებული
// თუ JwtUsernameAndPasswordAuthenticationFilter.attemptAuthentication მეთოდმა არ გაატარა ატენთიფიცირება ანუ არასწორი პაროლი შეიყვანა ან იუზერნეიმი შემოდის აქ. (Login ის დროს)
// აქ შემოვიდა იმ შემთხვევაშიც თუ არასწორ ტოკენს გადასცემს ფრონტი ანუ 1 სიმბოლოთ დიდს ან მცირეს.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");

        // How to customize the retured message?
        // Link: https://stackoverflow.com/a/40791087
        String json = String.format("{\"message\": \"%s\"}", e.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}