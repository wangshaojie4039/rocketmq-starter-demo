package com.aqlu.rocketmq.demo.service;

import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Service;

/**
 * @author wangshaojie
 */
@Service
public class TransactionExecuterImpl implements LocalTransactionExecuter {
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message message, Object o) {
        System.out.println("执行本地事务msg = " + new String(message.getBody()));

        System.out.println("执行本地事务arg = " + o);

        String tags = message.getTags();

        if (tags.equals("transaction2")) {
            System.out.println("======我的操作============，失败了  -进行ROLLBACK");
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
        // return LocalTransactionState.UNKNOW;
    }
}
