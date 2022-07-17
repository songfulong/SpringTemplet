package com.huawei.it.rabbitmq.controller;

import com.huawei.it.rabbitmq.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TestController {


    Map<String, Sender> senders;

    @Autowired
    public void setSenders(Map<String, Sender> senders) {
        this.senders = senders;
    }

    @GetMapping(path = "/test/send/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean sendMessage(@PathVariable(name = "type") String type) {
        String key = type + "Sender";
        if (senders.containsKey(key)) {
            senders.get(key).send();
            return true;
        }
        return false;
    }
}
