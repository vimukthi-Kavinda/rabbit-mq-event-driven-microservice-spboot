package com.zonetest.eventdriven.demosender.controller;

import com.zonetest.eventdriven.demosender.dto.RequestMsgBody;
import com.zonetest.eventdriven.demosender.service.SenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sender")
public class SenderController {

    private final SenderService senderService;

    Logger logger = LoggerFactory.getLogger(SenderController.class);
    @Autowired
    public SenderController(SenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMsg(@RequestBody RequestMsgBody requestMsgBody){
        logger.info("SenderController.sendMsg - init");
        senderService.sendMessage(requestMsgBody);
        logger.info("SenderController.sendMsg - done");
        return new ResponseEntity<>("Sent", HttpStatus.OK);
    }

    @GetMapping("/get-msg")
    public ResponseEntity<String> getMsg(){
        logger.info("SenderController.sendMsg - init");
        String msg = senderService.getMsg();
        logger.info("SenderController.sendMsg - done");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }



}
