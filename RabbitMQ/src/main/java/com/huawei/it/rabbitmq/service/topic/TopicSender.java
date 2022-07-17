package com.huawei.it.rabbitmq.service.topic;

import com.huawei.it.rabbitmq.service.Sender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender implements Sender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        Message message1 = getMessage("One");
        rabbitTemplate.send(AMQ_TOPIC, "One", message1);
        Message message2 = getMessage("One.One");
        rabbitTemplate.send(AMQ_TOPIC, "One.One", message2);
        Message message3 = getMessage("One.One.One");
        rabbitTemplate.send(AMQ_TOPIC, "One.One.One", message3);
    }
}
