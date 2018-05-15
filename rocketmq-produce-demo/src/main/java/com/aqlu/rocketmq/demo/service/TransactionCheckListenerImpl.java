package com.aqlu.rocketmq.demo.service;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionCheckListener;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 */
public class TransactionCheckListenerImpl implements TransactionCheckListener {
    @Override
    public LocalTransactionState checkLocalTransactionState(MessageExt messageExt) {
        System.out.println("未决事务，服务器回查客户端msg =" + new String(messageExt.getBody().toString()));
        // return LocalTransactionState.ROLLBACK_MESSAGE;

        return LocalTransactionState.COMMIT_MESSAGE;

        // return LocalTransactionState.UNKNOW;
    }
}
