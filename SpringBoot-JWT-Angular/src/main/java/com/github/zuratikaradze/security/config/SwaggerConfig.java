package com.github.zuratikaradze.security.config;


import com.github.zuratikaradze.security.controller.AuthController;
import com.github.zuratikaradze.security.controller.HelloController;
import com.github.zuratikaradze.security.controller.RoleController;
import com.github.zuratikaradze.security.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = RoleController.class)
@ComponentScan(basePackageClasses = HelloController.class)
@ComponentScan(basePackageClasses = AuthController.class)
@Configuration
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    private static final String title = "ZURA";
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String description = "JWT AUTH WITH DB AND SWAGGER";
    private static final String LICENSE_TEXT = "zuratikaradze.github.com";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENSE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .securityContexts(Arrays.asList(securityContext()))// საჭიროა ავტორიზაციისთვის jwt
                .securitySchemes(Arrays.asList(apiKey()))// საჭიროა ავტორიზაციისთვის jwt
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }


    // JWT Auth ისთვის .
    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.any()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
    }

}