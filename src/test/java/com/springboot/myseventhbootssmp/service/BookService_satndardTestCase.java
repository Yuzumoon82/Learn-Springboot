package com.springboot.myseventhbootssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.myseventhbootssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookService_satndardTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(7));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setType("测试数据2");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        bookService.update(book);
    }

    @Test
    void testDelete(){
        bookService.delete(15);
    }

    @Test
    void testGetAll(){
        List<Book> books = bookService.getAll();
        System.out.println(books);
    }

    @Test
    void testPage(){
        IPage<Book> page = bookService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
