package com.rabbitmq.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void send(String order) {
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
