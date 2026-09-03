package com.springboot.myseventhbootssmp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.myseventhbootssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetByID() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据1");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("测试数据2");
        book.setName("测试数据1");
        book.setDecription("测试数据1");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(13);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testPage(){
//        IPage内封装了所有有关分页的配置
        IPage page = new Page(2,5);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){

    }
}
