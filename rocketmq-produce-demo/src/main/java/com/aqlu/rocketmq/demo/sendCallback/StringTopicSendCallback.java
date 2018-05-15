package com.aqlu.rocketmq.demo.sendCallback;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author wangshaojie
 * stringTopic异步发送回调类
 */
@Slf4j
public class StringTopicSendCallback implements SendCallback {
    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("StringTopicSendCallback  onSuccess stringTopic 发送成功了");
    }

    @Override
    public void onException(Throwable throwable) {
        log.info("StringTopicSendCallback onException stringTopic 发送失败，进行消息持久化处理");
    }
}
