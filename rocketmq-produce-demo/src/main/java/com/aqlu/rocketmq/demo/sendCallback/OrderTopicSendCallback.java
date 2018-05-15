package com.aqlu.rocketmq.demo.sendCallback;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author wangshaojie
 * orderTopic 异步发送响应回调类
 */
@Slf4j
public class OrderTopicSendCallback implements SendCallback {
    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("OrderTopicSendCallback  onSuccess orderTopic 发送成功了");
    }

    @Override
    public void onException(Throwable throwable) {
        log.info("OrderTopicSendCallback onException orderTopic 发送失败，进行消息持久化处理");
    }
}
