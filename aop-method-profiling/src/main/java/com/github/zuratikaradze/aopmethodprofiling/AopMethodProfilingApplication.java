package com.github.zuratikaradze.aopmethodprofiling;

import com.github.zuratikaradze.aopmethodprofiling.service.FooService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AopMethodProfilingApplication {

    public static void main(String[] args) {

        SpringApplication.run(AopMethodProfilingApplication.class, args);

        // Create Spring application context that configured by xml.
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
        // Get our service from the spring context (that we want to be profiled).
        FooService fooService = ctx.getBean(FooService.class);

        // Test profiler through methods calls.

        for (int i = 0; i < 10; i++) {
            fooService.doShortJob();
        }
        fooService.doLongJob();

        // Test that profiler also can handle Exceptions in profiled method.
        fooService.doSomethingThatThrowsException();

        // Close the spring context
        ctx.close();



    }

}
