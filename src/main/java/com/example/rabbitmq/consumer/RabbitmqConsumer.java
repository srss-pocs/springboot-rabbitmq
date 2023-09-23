package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.dto.OrderStatus;
import com.example.rabbitmq.utils.ApplicationConstants;

@Component
public class RabbitmqConsumer {

	@RabbitListener(queues = ApplicationConstants.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
	
}
