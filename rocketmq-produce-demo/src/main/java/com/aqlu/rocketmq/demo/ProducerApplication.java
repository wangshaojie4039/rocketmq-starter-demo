package com.aqlu.rocketmq.demo;

import com.alibaba.fastjson.JSONObject;
import com.aqlu.rocketmq.demo.domain.OrderPaidEvent;
import com.aqlu.rocketmq.demo.sendCallback.OrderTopicSendCallback;
import com.aqlu.rocketmq.demo.sendCallback.StringTopicSendCallback;
import com.aqlu.rocketmq.demo.service.TransactionExecuterImpl;
import com.aqlu.rocketmq.demo.util.MsgConvertUtil;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.rocketmq.starter.annotation.EnableRocketMQ;
import org.rocketmq.starter.core.producer.MessageProxy;
import org.rocketmq.starter.core.producer.RocketMQProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author wangshaojie
 */
@SpringBootApplication
@EnableRocketMQ
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private RocketMQProducerTemplate rocketMQProducerTemplate;

    @Autowired
    private TransactionMQProducer transactionMQProducer;

//    @Autowired
//    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private TransactionExecuterImpl tranExecuter;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 1.send string
//        MessageProxy proxy = new MessageProxy();
//        //设置异步发送回调类
//        proxy.setSendCallback(new StringTopicSendCallback());
//        while (true) {
//            Thread.sleep(5000);
//            proxy.setMessage(new Message("string-topic", ("msg:" + System.currentTimeMillis()).getBytes()));
//            rocketMQProducerTemplate.send(proxy);
//        }

        //2.send trasaction mes
//        for (int i = 1; i <= 3; i++) {
//            Message msg = new Message("TopicTransactionTest", "transaction" + i, "KEY" + i,
//                    ("Hello RocketMQ " + i).getBytes());
//            SendResult sendResult = transactionMQProducer.sendMessageInTransaction(msg, tranExecuter, null);
//            System.out.println(sendResult);
//            Thread.sleep(10);
//        }
        //3.send orderly msg
        MessageProxy proxy = new MessageProxy();
        proxy.setSendCallback(new OrderTopicSendCallback());

        for (int i = 0; i < 1000; i++) {
            int orderId=i%10;
            Message message=new Message("order_topic","Tag"+orderId,("orderId_"+i).getBytes());
            proxy.setMessage(message);
            proxy.setMessageQueueSelector(new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id=(Integer)o;
                    int index=id%list.size();
                    return list.get(index);
                }
            });
            proxy.setSelectorArg(orderId);
            rocketMQProducerTemplate.send(proxy);
        }
        //4 send delay msg
//        MessageProxy proxy=new MessageProxy();
//        Message message=new Message("delay_topic","tagA","delay msg".getBytes());
//        message.setDelayTimeLevel(5);
//        proxy.setMessage(message);
//        proxy.setSendCallback(new StringTopicSendCallback());
//        rocketMQProducerTemplate.send(proxy);
        //send
//        MessageProxy proxy = new MessageProxy();
//        for (int i = 1; i <= 10; i++) {
//
//            proxy.setMessage(new Message("message_model_topic", "tagA",
//                    JSONObject.toJSONBytes(new OrderPaidEvent("orderId_"+i,"paid"))));
//            proxy.setSendCallback(new StringTopicSendCallback());
//            rocketMQProducerTemplate.send(proxy);
//        }
//        Message message=new
// Message("order_topic","Tag"+1,("orderId_"+1).getBytes());
//        defaultMQProducer.send(message);
    }

}
