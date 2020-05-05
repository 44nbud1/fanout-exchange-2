package com.latihan.rabbitmqfanout;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqFanoutApplication {

    /*
    configuration rabbit mq
     */

    private static final String marketingQueue = "marketingQueue";
    private static final String financeQueue = "financeQueue";
    private static final String adminQueue = "adminQueue";
    private static final String exchange = "fanout-exchange";

    @Bean
    Queue marketingQueue()
    {
        return new Queue(marketingQueue,true);
    }

    @Bean
    Queue financeQueue()
    {
        return new Queue(financeQueue, true);
    }

    @Bean
    Queue adminQueue()
    {
        return new Queue(adminQueue,true);
    }

    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(exchange);
    }

    @Bean
    Binding marketingBinding  (Queue marketingQueue, FanoutExchange exchange)
    {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }

    @Bean
    Binding financeBinding (Queue financeQueue, FanoutExchange exchange)
    {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }

    @Bean
    Binding adminBinding (Queue adminQueue, FanoutExchange exchange)
    {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }

    // communication

    @Bean
    MessageConverter jsonConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonConverter());
        return rabbitTemplate;
    }

    // main
    public static void main(String[] args)
    {
        SpringApplication.run(RabbitmqFanoutApplication.class, args);
    }

}
