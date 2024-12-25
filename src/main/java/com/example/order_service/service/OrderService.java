package com.example.order_service.service;

import com.example.order_service.entity.Order;
import com.example.order_service.entity.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private static final String ORDER_TOPIC = "order-topic";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void createOrder(Order order) {
        log.info("Creating order for product {} with quantity {}", order.getProduct(), order.getQuantity());
        OrderEvent orderEvent = new OrderEvent(order.getProduct(), order.getQuantity());
        kafkaTemplate.send(ORDER_TOPIC, orderEvent);
    }
}
