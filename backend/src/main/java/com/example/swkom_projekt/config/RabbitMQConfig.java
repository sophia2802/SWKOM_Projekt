package com.example.swkom_projekt.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue documentQueue() {
        return new Queue("documentQueue", false);
    }

    @Bean
    public Queue ocrResultQueue() {
        return new Queue("ocrResultQueue", false);
    }
}
