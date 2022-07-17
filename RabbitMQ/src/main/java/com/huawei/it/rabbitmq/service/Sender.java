package com.huawei.it.rabbitmq.service;

import org.springframework.amqp.core.Message;

import java.nio.charset.StandardCharsets;

public interface Sender {
    String AMQ_DIRECT = "amq.direct";

    String AMQ_FANOUT = "amq.fanout";

    String AMQ_TOPIC = "amq.topic";

    String AMQ_HEADERS = "amq.headers";

    void send();

    default Message getMessage(String routingKey) {
        String messageInfo = "hello, rabbit, routingKey is" + routingKey;
        Message message = new Message(messageInfo.getBytes(StandardCharsets.UTF_8));
        return message;
    }
}
