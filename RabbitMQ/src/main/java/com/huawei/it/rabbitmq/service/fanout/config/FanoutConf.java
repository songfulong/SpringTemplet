package com.huawei.it.rabbitmq.service.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConf {

    @Bean(name = "fanoutQueue1")
    public Queue QueueMessage1() {
        return new Queue("fanoutQueue1");
    }


    @Bean(name = "fanoutQueue2")
    public Queue QueueMessage2() {
        return new Queue("fanoutQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new FanoutExchange("amq.fanout", true, false, null);
    }

    @Bean
    public Binding bingFanoutExchange1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1)   //绑定队列
                .to(fanoutExchange); //队列绑定到哪个交换器

    }

    @Bean
    public Binding bingFanoutExchange2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2)   //绑定队列
                .to(fanoutExchange);         //队列绑定到哪个交换器
    }
}
