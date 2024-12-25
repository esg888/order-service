package com.example.order_service.kafka;

import com.example.order_service.entity.OrderStatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "order-status-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, OrderStatusEvent> record) {
        log.info("Received message: {}", record.value());
        log.info("Key: {}; Partition: {}; Topic: {}, Timestamp: {}",
                record.key(),
                record.partition(),
                record.topic(),
                record.timestamp()
        );
    }
}
