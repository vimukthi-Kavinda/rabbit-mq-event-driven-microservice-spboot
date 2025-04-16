package com.zonetest.eventdriven.demorecver2.listener;

import com.zonetest.eventdriven.demorecver2.dto.EventMsgBody;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.function.Consumer;

@Configuration
@Order(2)
public class MessageListener {

    @Bean
    public Consumer<EventMsgBody> eventMsg(){
        return eventMsgBody -> {
            System.out.println("Message recved "+eventMsgBody.getMsg()+" "+eventMsgBody.getSender());
        };
    }

}
