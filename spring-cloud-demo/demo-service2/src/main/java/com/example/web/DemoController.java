package com.example.web;

import com.example.bean.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {
    @Resource
    private Book book;
    @RequestMapping("/demo")
    public Book demo(){
        System.out.println(book.getName());
        System.out.println(book.getAuthor());
        System.out.println(book.getDesc());
        return book;
    }
}
