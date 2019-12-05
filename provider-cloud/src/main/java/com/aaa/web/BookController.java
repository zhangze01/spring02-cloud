package com.aaa.web;

import com.aaa.InterfaceTest.BookService;
import com.aaa.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组合注解
 * controller+responseBody=RestController
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    private int i=1;
    @GetMapping("/getAllBook")
    public List<BookInfo> getAllBook(){
        List<BookInfo> bookInfos = bookService.selAllBook();
        for(BookInfo bookInfo: bookInfos){
            System.out.println(bookInfo);
        }
        if(++i%2==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return  bookInfos;

    }
}
