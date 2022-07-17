package com.huawei.it.rabbitmq.service.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConf {

    @Bean(name = "directQueue1")
    public Queue QueueMessage1() {
        return new Queue("directQueue1");
    }


    @Bean(name = "directQueue2")
    public Queue QueueMessage2() {
        return new Queue("directQueue2");
    }

    @Bean
    public DirectExchange directExchange() {
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new DirectExchange("amq.direct", true, false, null);
    }

    @Bean
    public Binding bingDirectExchange1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1)   //绑定队列
                .to(directExchange)       //队列绑定到哪个交换器
                .with("One");         //绑定路由key,必须指定
    }

    @Bean
    public Binding bingDirectExchange2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2)   //绑定队列
                .to(directExchange)       //队列绑定到哪个交换器
                .with("Two");         //绑定路由key,必须指定
    }
}
