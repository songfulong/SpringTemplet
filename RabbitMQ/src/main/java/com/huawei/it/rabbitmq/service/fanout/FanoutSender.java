package com.huawei.it.rabbitmq.service.fanout;

import com.huawei.it.rabbitmq.service.Sender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender implements Sender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        Message message1 = getMessage("one");
        rabbitTemplate.send(AMQ_FANOUT, "", message1);
        Message message2 = getMessage("Two");
        rabbitTemplate.send(AMQ_FANOUT, "", message2);
    }
}
