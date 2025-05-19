package com.zonetest.eventdriven.demorecver1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-recver1")
public class DemoRecver1Controller {

    @GetMapping("/get-recver-msg")
    public ResponseEntity<String> getMsg(){
        return new ResponseEntity<>("msg from demo recver1", HttpStatus.OK);
    }
}
