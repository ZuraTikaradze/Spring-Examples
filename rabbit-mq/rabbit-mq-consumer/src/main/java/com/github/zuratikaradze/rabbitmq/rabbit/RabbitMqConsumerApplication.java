package com.github.zuratikaradze.rabbitmq.rabbit;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumerApplication.class, args);
    }

    // ეს გვჭირდება იმიტო რო შემოსული ობიექტის დესერიალიზაცია გააკეთოს // შეგვილია სერვისშიც ჩავტენოთ
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
