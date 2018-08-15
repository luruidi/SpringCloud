package com.example.controller;

import com.example.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RibbonHystrixService ribbonHystrixService;
    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String consumer(){
        //return restTemplate.getForEntity("http://demo-service/demo",String.class).getBody();
        return ribbonHystrixService.Consumer();
    }
}
