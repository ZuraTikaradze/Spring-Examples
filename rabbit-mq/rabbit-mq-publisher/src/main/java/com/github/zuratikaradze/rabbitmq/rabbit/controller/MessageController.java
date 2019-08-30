package com.github.zuratikaradze.rabbitmq.rabbit.controller;

import com.github.zuratikaradze.rabbitmq.rabbit.model.Employee;
import com.github.zuratikaradze.rabbitmq.rabbit.service.RabbitSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MessageController {

    @Autowired
    RabbitSenderService rabbitSenderService;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        // ამას ესე ცუდად იმიტო ვაკეთებ რო პოსტმენის გახსნა მეზარება და ობიექტის დარექვესთება ;)
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitSenderService.send(emp);
        return "Successfully Sended !!!";
    }
}
