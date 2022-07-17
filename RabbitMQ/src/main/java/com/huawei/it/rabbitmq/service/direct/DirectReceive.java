package com.huawei.it.rabbitmq.service.direct;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class DirectReceive {
    private static final Logger LOG = LoggerFactory.getLogger(DirectReceive.class);


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "directQueue1", durable = "true"),
            exchange = @Exchange(value = "amq.direct", type = "direct", durable = "true"),
            key = "One")
    )
    public void tsDirect1Msg(Message data, Channel channel, @Payload String body, @Headers Map<String, Object> headers) {
        parseMessage(data, body, headers, 1);
    }

    private void parseMessage(Message data, @Payload String body, @Headers Map<String, Object> headers, int index) {
        try {
            LOG.error("this is directQueue{}, message = {} ", index, body);
            LOG.error("this is directQueue{}, headers = {}  ", index, JSON.toJSONString(headers));
            String str = new String(data.getBody(), StandardCharsets.UTF_8);
            LOG.error("this is directQueue{}, Message data = {} , messageProperties={} ", index, str, JSON.toJSONString(data.getMessageProperties()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "directQueue2", durable = "true"),
            exchange = @Exchange(value = "amq.direct", type = "direct", durable = "true"),
            key = "Two")
    )
    public void tsDirect2Msg(Message data, Channel channel, @Payload String body, @Headers Map<String, Object> headers) {
        parseMessage(data, body, headers, 2);
    }

}
