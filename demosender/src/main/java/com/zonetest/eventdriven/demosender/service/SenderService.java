package com.zonetest.eventdriven.demosender.service;

import com.zonetest.eventdriven.demosender.dto.EventMsgBody;
import com.zonetest.eventdriven.demosender.dto.RequestMsgBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class SenderService {

    @Autowired
    private StreamBridge streamBridge;

    Logger logger = LoggerFactory.getLogger(SenderService.class);

    public static final String BINDING_NAME = "eventMsg-out-0";
    public void sendMessage(RequestMsgBody requestMsgBody) {
        logger.info("Sending msg : {}",requestMsgBody.getMsg());
        streamBridge.send(BINDING_NAME,new EventMsgBody(requestMsgBody.getMsg()+ "  " +ZonedDateTime.now().toString(),"Sender service" ));
        logger.info("Sent");
    }
}
