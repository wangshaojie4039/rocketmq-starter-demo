package com.aqlu.rocketmq.demo.config;

import com.aqlu.rocketmq.demo.service.TransactionCheckListenerImpl;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.rocketmq.starter.configuration.RocketMQAutoConfiguration;
import org.rocketmq.starter.core.producer.ProducerConfigRocket;
import org.rocketmq.starter.core.producer.RocketMQProducerTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author wangshaojie
 */
@Configuration
public class RocketMQProducerConfig extends RocketMQAutoConfiguration {

    @Value("${spring.rocketmq.name-server}")
    private String nameServer;

    @Value("${spring.rocketmq.producer.group}")
    private String producerGroup;

    @Bean(name = "rocketMQProducerTemplate")
    public RocketMQProducerTemplate rocketMQProducerTemplate(ProducerConfigRocket producerConfig) throws Exception {
        //producerConfig.setOrderlyMessage(true);
        RocketMQProducerTemplate bean = new RocketMQProducerTemplate();
        bean.setNamesrvAddr(nameServer);
        bean.setProducerConfig(producerConfig);
        return bean;
    }

    @Bean(name = "transactionMQProducer")
    public TransactionMQProducer transactionMQProducer(ProducerConfigRocket producerConfig) throws Exception {
        TransactionMQProducer bean = new TransactionMQProducer("transaction_Producer");
        bean.setNamesrvAddr(nameServer);
        // 事务回查最小并发数
        bean.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        bean.setCheckThreadPoolMaxSize(2);
        // 队列数
        bean.setCheckRequestHoldMax(2000);
        bean.setTransactionCheckListener(new TransactionCheckListenerImpl());
        bean.start();
        return bean;
    }

    @Bean(name = "orderlyMQProducer")
    public DefaultMQProducer orderlyMQProducer(ProducerConfigRocket producerConfig) throws Exception {
        DefaultMQProducer bean=new DefaultMQProducer();
        bean.setVipChannelEnabled(false);
        return bean;
    }

//    @Bean(name = "defaultMQProducer")
//    public DefaultMQProducer DefaultMQProducer(ProducerConfigRocket producerConfig) throws Exception {
//        DefaultMQProducer bean=new DefaultMQProducer();
//        bean.setVipChannelEnabled(false);
//        bean.setProducerGroup(producerConfig.getProducerGroup());
//        bean.setSendMsgTimeout(producerConfig.getTimeOut());
//        bean.setNamesrvAddr(nameServer);
//        bean.start();
//        return bean;
//    }

    @Bean("producerConfig")
    public ProducerConfigRocket producerConfig() throws Exception {
        ProducerConfigRocket bean = new ProducerConfigRocket();
        bean.setProducerGroup(producerGroup);
        return bean;
    }
}
