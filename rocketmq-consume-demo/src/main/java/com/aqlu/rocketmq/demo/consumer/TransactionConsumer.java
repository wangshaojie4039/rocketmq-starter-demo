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
@RocketMQListener(topic = "TopicTransactionTest",consumerGroup = "transation_consumer")
public class TransactionConsumer {

    @RocketMQMessage(messageClass = String.class,tag = "transaction1")
    public void onMessage(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received message  TopicTransactionTest transaction1: {}", message);
    }
    @RocketMQMessage(messageClass = String.class,tag = "transaction2")
    public void onMessage1(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received message  TopicTransactionTest transaction2: {}", message);
    }

    @RocketMQMessage(messageClass = String.class,tag = "transaction3")
    public void onMessage2(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received message  TopicTransactionTest transaction3: {}", message);
    }


}
