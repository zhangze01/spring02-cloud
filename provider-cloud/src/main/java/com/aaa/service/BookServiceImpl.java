package com.aaa.service;

import com.aaa.InterfaceTest.BookService;
import com.aaa.mapper.BookMapper;
import com.aaa.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override 
    public List<BookInfo> selAllBook() {
        return bookMapper.selAllBook();
    }
}
