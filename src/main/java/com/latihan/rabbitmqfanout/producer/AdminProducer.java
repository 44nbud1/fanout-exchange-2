package com.latihan.rabbitmqfanout.producer;

import com.latihan.rabbitmqfanout.model.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminProducer
{
    @Autowired
    private RabbitTemplate template;

    private static final String exchange = "fanout-exchange";

    public void admin(Item item)
    {
        template.convertAndSend(exchange,"",item);
    }
}
