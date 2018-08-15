package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonHystrixService {
    @Autowired
    private RestTemplate restTemplate ;
    @HystrixCommand(fallbackMethod = "hystrix") //Hystrix断路器默认超时时间为2*1000ms
    public String Consumer(){
        return restTemplate.getForEntity("http://demo-service/demo",String.class).getBody();
    }

    public String hystrix(){
        return "error";
    }
}
