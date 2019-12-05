package com.aaa.web;

import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignBookController {
    @Autowired
    private BookService bookService;
    @GetMapping("feignGetAllBook")
    public List<BookInfo> getAllBook(){
        List<BookInfo> allBook = bookService.getAllBook();
        System.out.println(allBook);
        return allBook;
    }
}
