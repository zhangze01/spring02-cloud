package com.aaa.web;

import com.aaa.model.BookInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class RibbonConsumerBookController {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("ribbonGetAllBook")
    public List<BookInfo> getAllBook(){
        LinkedList forObject = restTemplate.getForObject("http://provider-server/getAllBook", LinkedList.class);
        return  forObject;

    }
    public List<BookInfo>  error(){
        System.out.println("服务熔断了");
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookName("暮光之城");
        List<BookInfo> l=new ArrayList<BookInfo>();
        l.add(bookInfo);
        return l;
    }
}
