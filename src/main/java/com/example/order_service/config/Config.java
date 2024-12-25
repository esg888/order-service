package com.example.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class Config {
    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("order-topic").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic orderStatusTopic() {
        return TopicBuilder.name("order-status-topic").partitions(1).replicas(1).build();
    }
}
