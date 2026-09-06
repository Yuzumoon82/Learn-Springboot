package com.springboot.myseventhbootssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

//    queryWrapper是查询条件

    @Test
    void testPage(){
//        IPage内封装了所有有关分页的配置
//        IPage是分页接口，Page是 MyBatis-Plus 提供的分页实现类
        IPage page = new Page(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

//    条件查询
    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<Book>();
        qw.like("type","盗墓探险");
        bookDao.selectList(qw);
    }
    @Test
    void testGetBy2(){
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(name != null,Book::getType,"法医");
        bookDao.selectList(lqw);
    }

}
