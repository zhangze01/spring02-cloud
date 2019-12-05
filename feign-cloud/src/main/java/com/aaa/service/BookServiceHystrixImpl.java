package com.aaa.service;

        import com.aaa.model.BookInfo;
        import org.springframework.stereotype.Service;

        import java.util.List;
@Service
public class BookServiceHystrixImpl implements BookService {
    @Override
    public List<BookInfo> getAllBook() {
        System.out.println("服务降级中");
        return null;
    }
}
