package com.latihan.rabbitmqfanout.consumer.marketing;

import com.latihan.rabbitmqfanout.model.Item;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerA
{
    @Autowired
    RabbitTemplate rabbitTemplate;

    private static final String queue = "marketingQueue";

    @RabbitListener(queues = queue)
    public void consumerA(Item item)
    {
        System.out.println("Consumer A");
        System.out.println(item.getId());
        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}
