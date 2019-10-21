package com.github.zuratikaradze.aop;

import com.github.zuratikaradze.aop.model.Person;
import com.github.zuratikaradze.aop.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

    //    System.out.println("Main : " + employeeService.getEmployee().getName());

        employeeService.getEmployee().setName("Pankaj");
//
//        employeeService.getEmployee().throwException();


        Person person=ctx.getBean("person",Person.class);
        person.setName("kkkk");
        System.out.println(person.getName());
        ctx.close();
    }

}
