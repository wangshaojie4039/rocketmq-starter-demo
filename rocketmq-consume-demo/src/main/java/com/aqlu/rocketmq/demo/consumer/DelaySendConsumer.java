package com.aqlu.rocketmq.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 * 延时消息消费类
 */
@Slf4j
@Service
@RocketMQListener(topic = "delay_topic",consumerGroup = "delay_consumer")
public class DelaySendConsumer {

    @RocketMQMessage(messageClass = String.class,tag = "tagA")
    public void onMessage(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received message  DelaySendConsumer tagA: {}", message);
    }

}
