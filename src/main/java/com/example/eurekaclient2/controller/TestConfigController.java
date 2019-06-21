package com.example.eurekaclient2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class TestConfigController {
    @Value("${dir}")
    private String dir;

    @GetMapping("/getNetMsg")
    public String getNetMsg(){
        log.info("dir={}",this.dir);
        return null;
    }

}
