package com.latihan.rabbitmqfanout.consumer.admin;

import com.latihan.rabbitmqfanout.model.Item;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerE
{
    private static final String exchange = "adminQueue";

    @RabbitListener(queues = exchange)
    public void showD(Item item)
    {
        System.out.println("Consumer E");
        System.out.println(item.getId());
        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}
