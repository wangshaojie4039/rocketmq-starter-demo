package com.aqlu.rocketmq.demo.consumer;

import com.aqlu.rocketmq.demo.domain.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.rocketmq.starter.annotation.RocketMQListener;
import org.rocketmq.starter.annotation.RocketMQMessage;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 * 集群和广播消费
 */
@Slf4j
@Service
@RocketMQListener(topic = "message_model_topic",consumerGroup = "message_model_consumer1",messageModel= MessageModel.BROADCASTING)
public class MessageModelConsumer1 {

    @RocketMQMessage(messageClass = OrderPaidEvent.class,tag = "tagA")
    public void onMessage1(OrderPaidEvent message) {
        //对于抛出异常的情况，系统返回ConsumeConcurrentlyStatus.RECONSUME_LATER 重试
        log.info("received MessageModelConsumer1 tagA: {}", message.getOrderId()+"action"+message.getAction());
    }
}
