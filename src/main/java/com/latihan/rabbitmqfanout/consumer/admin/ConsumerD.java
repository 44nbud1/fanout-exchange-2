package com.latihan.rabbitmqfanout.consumer.admin;

import com.latihan.rabbitmqfanout.model.Item;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerD
{
    private static final String queue = "adminQueue";

    @RabbitListener(queues = queue)
    public void takeConsumerD(Item item)
    {
        System.out.println("Consumer D");
        System.out.println(item.getId());
        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}
