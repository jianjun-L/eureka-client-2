package com.example.eurekaclient2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class EurekaClientBalanceController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getInfo3")
   public String getInfo3(){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("EUREKA-CLIENT-1");
        String url = String.format("http://%s:%s",instance.getHost(),instance.getPort()+"/info");
        String res = restTemplate.getForObject(url,String.class);
        log.info("res==={}",res);
      return res;
   }

}
