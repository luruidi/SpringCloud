package com.example.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.Bean.Book;
import com.example.Service.FeignConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumetController {
    @Autowired
    private FeignConsumerService feignConsumerService;
    @RequestMapping(value = "/feignConsumer",method = RequestMethod.GET)
    public Book FeiginConsumer(){
        JSONObject jb = feignConsumerService.feignConsumer();
        String jsStr = jb.toJSONString();
        String str = jb.toString();
        Book book = JSONObject.parseObject(str, Book.class);
        return book;
    }
}
