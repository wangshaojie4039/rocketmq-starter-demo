package com.aqlu.rocketmq.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 * 顺序消费
 */
@Slf4j
@Service
@RocketMQListener(topic = "order_topic",consumerGroup = "order_consumer" ,orderly = true)
public class OrderConsumer {

    @RocketMQMessage(messageClass = String.class,tag = "Tag0")
    public void onMessage0(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
      //  log.info("received message  OrderConsumer Tag0: {}", message);
    }

    @RocketMQMessage(messageClass = String.class,tag = "Tag1")
    public void onMessage1(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        //log.info("received message  OrderConsumer Tag1: {}", message);
    }

    @RocketMQMessage(messageClass = String.class,tag = "Tag2")
    public void onMessage2(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
       // log.info("received message  OrderConsumer Tag2: {}", message);
    }


    @RocketMQMessage(messageClass = String.class,tag = "Tag3")
    public void onMessage3(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
       // log.info("received message  OrderConsumer Tag3: {}", message);
    }

    @RocketMQMessage(messageClass = String.class,tag = "Tag4")
    public void onMessage4(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received message  OrderConsumer Tag4: {}", message);
    }

    @RocketMQMessage(messageClass = String.class,tag = "Tag5")
    public void onMessage5(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
       // log.info("received message  OrderConsumer Tag5: {}", message);
    }


    @RocketMQMessage(messageClass = String.class,tag = "Tag6")
    public void onMessage6(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        //log.info("received message  OrderConsumer Tag6: {}", message);
    }


    @RocketMQMessage(messageClass = String.class,tag = "Tag7")
    public void onMessage7(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        //log.info("received message  OrderConsumer Tag7: {}", message);
    }


    @RocketMQMessage(messageClass = String.class,tag = "Tag8")
    public void onMessage8(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
       // log.info("received message  OrderConsumer Tag8: {}", message);
    }



    @RocketMQMessage(messageClass = String.class,tag = "Tag9")
    public void onMessage9(String message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        //log.info("received message  OrderConsumer Tag9: {}", message);
    }
}
