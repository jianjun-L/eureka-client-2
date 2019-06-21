package com.example.eurekaclient2.controller;

import com.example.eurekaclient2.client.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class EurekaClientController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/getInfo")
    public String getInfo(){
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject("http://127.0.0.1:8802/info",String.class);
        log.info("res={}",res);
        return res;
    }

    @GetMapping("/getInfo1")
    public String getInfo1(){
        String res = restTemplate.getForObject("http://EUREKA-CLIENT-1/info",String.class);
        log.info("res=={}",res);
        return res;
    }

    @GetMapping("/getMessage")
    public String getMessage(){
        String res =  eurekaClient.getInfo();
        log.info("res=>{}",res);
        return res;
    }
}
