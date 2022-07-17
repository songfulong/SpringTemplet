package com.huawei.it.rabbitmq.service.headers;

import com.huawei.it.rabbitmq.service.Sender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadersSender implements Sender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        Message message1 = getMessage(null);
        message1.getMessageProperties().setHeader("one", "one");
        rabbitTemplate.send(AMQ_HEADERS, null, message1);
        Message message2 = getMessage(null);
        message2.getMessageProperties().setHeader("two", "two");
        rabbitTemplate.send(AMQ_HEADERS, null, message2);
        // 无法接受,因为默认对列无效
        Message message3 = getMessage(null);
        message3.getMessageProperties().setHeader("two", "two");
        rabbitTemplate.send(message3);
    }

}
