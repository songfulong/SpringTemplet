package com.huawei.it.rabbitmq.service.fanout;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class FanoutReceive {
    private static final Logger LOG = LoggerFactory.getLogger(FanoutReceive.class);


    /**
     * QueueBinding
     *
     * @param data
     * @param channel
     * @param body
     * @param headers
     */
    @RabbitListener(queues = {"fanoutQueue1"}
    )
    public void tsfanout1Msg(Message data, Channel channel, @Payload String body, @Headers Map<String, Object> headers) {
        parseMessage(data, body, headers, 1);
    }

    private void parseMessage(Message data, @Payload String body, @Headers Map<String, Object> headers, int index) {
        try {
            LOG.error("this is fanoutQueue{}, message = {} ", index, body);
            LOG.error("this is fanoutQueue{}, headers = {}  ", index, JSON.toJSONString(headers));
            String str = new String(data.getBody(), StandardCharsets.UTF_8);
            LOG.error("this is fanoutQueue{}, Message data = {} , messageProperties={} ", index, str, JSON.toJSONString(data.getMessageProperties()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = {"fanoutQueue2"}
    )
    public void tsfanout2Msg(Message data, Channel channel, @Payload String body, @Headers Map<String, Object> headers) {
        parseMessage(data, body, headers, 2);
    }

}
