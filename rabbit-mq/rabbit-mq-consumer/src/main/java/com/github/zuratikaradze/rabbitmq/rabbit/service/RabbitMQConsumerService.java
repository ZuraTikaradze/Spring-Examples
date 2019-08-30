package com.github.zuratikaradze.rabbitmq.rabbit.service;

import com.github.zuratikaradze.rabbitmq.rabbit.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerService {
    @RabbitListener(queues = "${zt.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }
}
