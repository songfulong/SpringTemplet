package com.huawei.it.rabbitmq.service.headers.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeadersConf {

    @Bean(name = "headerQueue1")
    public Queue QueueMessage1() {
        return new Queue("headersQueue1");
    }


    @Bean(name = "headerQueue2")
    public Queue QueueMessage2() {
        return new Queue("headersQueue2");
    }

    @Bean
    public HeadersExchange headerExchange() {
        //参数介绍
        //1.交换器名 2.是否持久化 3.自动删除 4.其他参数
        return new HeadersExchange("amq.headers", true, false, null);
    }

    @Bean
    public Binding bingheaderExchange1(Queue headerQueue1, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headerQueue1)   //绑定队列
                .to(headersExchange).whereAny("one", "two").exist(); //队列绑定到哪个交换器
    }

    @Bean
    public Binding bingheaderExchange2(Queue headerQueue2, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headerQueue2)   //绑定队列
                .to(headersExchange).whereAny("one", "two").exist();         //队列绑定到哪个交换器
    }
}
