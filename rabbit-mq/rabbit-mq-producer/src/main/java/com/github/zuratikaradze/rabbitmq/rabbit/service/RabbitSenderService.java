package com.github.zuratikaradze.rabbitmq.rabbit.service;

import com.github.zuratikaradze.rabbitmq.rabbit.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitSenderService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${zt.rabbitmq.exchange}")
    private String exchange;

    @Value("${zt.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employee) {
        rabbitTemplate.convertAndSend(exchange, routingkey, employee);
        System.out.println("Send msg = " + employee);

    }
}
