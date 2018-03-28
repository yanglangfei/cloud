package com.yf.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "product")
@Slf4j
public class ProductListener {

    @RabbitHandler
    public void process(String user) {
        log.info("Receiver: {} ",user);
    }


}
