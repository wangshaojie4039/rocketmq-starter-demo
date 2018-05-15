package com.aqlu.rocketmq.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 */
@Slf4j
@Service
@RocketMQListener(topic = "order-paid-topic", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer {

    @RocketMQMessage(messageClass = String.class, tag = "tag-1")
    public void onMessage(String message) {
        log.info("received message: {}", message);
    }
}
