package com.latihan.rabbitmqfanout.producer;

import com.latihan.rabbitmqfanout.model.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketingProducer
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchange = "fanout-exchange";

    public void marketingProducer(Item item)
    {
        rabbitTemplate.convertAndSend(exchange,"",item);
    }
}
