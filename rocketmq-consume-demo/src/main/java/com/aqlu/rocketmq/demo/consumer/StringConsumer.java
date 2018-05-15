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
@RocketMQListener(topic = "string-topic",consumerGroup = "string-group")
public class StringConsumer {
    @RocketMQMessage(messageClass = String.class)
    public void onMessage(String message) {
        //log.info("received message: {}", message);
    }
}
