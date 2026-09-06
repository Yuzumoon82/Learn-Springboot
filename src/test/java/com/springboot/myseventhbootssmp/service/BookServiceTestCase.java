package com.springboot.myseventhbootssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.myseventhbootssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById(){
        System.out.println(iBookService.getById(7));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        iBookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setType("测试数据2");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        iBookService.updateById(book);
    }

    @Test
    void testDelete(){
        iBookService.removeById(15);
    }

    @Test
    void testGetAll(){
        List<Book> books = iBookService.list();
        System.out.println(books);
    }

    @Test
    void testPage(){
        IPage<Book> page = new Page<>(2,5);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
