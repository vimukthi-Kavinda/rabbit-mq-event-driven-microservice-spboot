package com.zonetest.eventdriven.demosender.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demorecver1",url = "http://localhost:8077/")
public interface DemoRecver1Service {
    @GetMapping("/demo-recver1/get-recver-msg")
    ResponseEntity<String> getMsg();
}
