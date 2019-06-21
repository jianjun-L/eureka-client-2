package com.example.eurekaclient2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="eureka-client-1")
public interface EurekaClient {
    @GetMapping("/info")
    String getInfo();
}
