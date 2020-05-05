package com.latihan.rabbitmqfanout.controller;

import com.latihan.rabbitmqfanout.consumer.admin.ConsumerD;
import com.latihan.rabbitmqfanout.consumer.admin.ConsumerE;
import com.latihan.rabbitmqfanout.consumer.admin.ConsumerF;
import com.latihan.rabbitmqfanout.consumer.marketing.ConsumerA;
import com.latihan.rabbitmqfanout.consumer.marketing.ConsumerB;
import com.latihan.rabbitmqfanout.consumer.marketing.ConsumerC;
import com.latihan.rabbitmqfanout.model.Item;
import com.latihan.rabbitmqfanout.producer.AdminProducer;
import com.latihan.rabbitmqfanout.producer.MarketingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController
{
    @Autowired
    private MarketingProducer marketingProducer;

    @Autowired
    private AdminProducer adminProducer;

    @Autowired
    private ConsumerA consumerA;

    @Autowired
    private ConsumerB consumerB;

    @Autowired
    private ConsumerC consumerC;

    @Autowired
    private ConsumerD consumerD;

    @Autowired
    private ConsumerE consumerE;

    @Autowired
    private ConsumerF consumerF;

    @PostMapping("/fanout")
    public ResponseEntity<?> addMarketing(@RequestBody Item item)
    {
        adminProducer.admin(item);


        return ResponseEntity.ok("ok");
    }

    @PostMapping("/fanout-item")
    public ResponseEntity<?> addAdmin(@RequestBody Item item)
    {
        marketingProducer.marketingProducer(item);

        consumerD.takeConsumerD(item);
        consumerE.showD(item);
        consumerF.showF(item);
        return ResponseEntity.ok("ok");
    }
}
