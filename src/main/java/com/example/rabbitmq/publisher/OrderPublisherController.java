package com.example.rabbitmq.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.dto.Order;
import com.example.rabbitmq.dto.OrderStatus;
import com.example.rabbitmq.utils.ApplicationConstants;

@RestController
@RequestMapping("/api/order")
public class OrderPublisherController {

	@Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public OrderStatus bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
    	String id = UUID.randomUUID().toString();
        order.setOrderId(id);
        /* Create a transaction to fulfill order and payment then place info to customer [restaurant service, payment service] */
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        template.convertAndSend(ApplicationConstants.EXCHANGE, ApplicationConstants.ROUTING_KEY, orderStatus);
        return orderStatus;
    }
    
}
