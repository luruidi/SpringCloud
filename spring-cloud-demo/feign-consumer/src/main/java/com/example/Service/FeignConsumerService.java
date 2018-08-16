package com.example.Service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-service")
public interface FeignConsumerService {
    @RequestMapping(value = "/demo")
    JSONObject feignConsumer();
}
