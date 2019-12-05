package com.aaa.service;

import com.aaa.model.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {
    /**
     * 得到所有的书籍
     * @return
     */
    @GetMapping("/getAllBook")
    List<BookInfo> getAllBook();
}
