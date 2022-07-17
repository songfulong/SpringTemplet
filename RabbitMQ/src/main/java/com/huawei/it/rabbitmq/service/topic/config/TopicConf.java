package com.huawei.it.rabbitmq.service.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConf {

    @Bean(name = "topicQueue1")
    public Queue QueueMessage1() {
        return new Queue("topicQueue1");
    }


    @Bean(name = "topicQueue2")
    public Queue QueueMessage2() {
        return new Queue("topicQueue2");
    }

    @Bean
    public TopicExchange topicExchange() {
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new TopicExchange("amq.topic", true, false, null);
    }

    @Bean
    public Binding bingtopicExchange1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1)   //绑定队列
                .to(topicExchange).with("*.One"); //队列绑定到哪个交换器
    }

    @Bean
    public Binding bingtopicExchange2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2)   //绑定队列
                .to(topicExchange).with("#.One.#");         //队列绑定到哪个交换器
    }
}
