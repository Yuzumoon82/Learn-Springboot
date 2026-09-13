package com.springboot.myseventhbootssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.springboot.myseventhbootssmp.dao.BookDao;
import com.springboot.myseventhbootssmp.domain.Book;
import com.springboot.myseventhbootssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        if(book != null){
            lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
            lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
            lqw.like(Strings.isNotEmpty(book.getDecription()),Book::getDecription,book.getDecription());
        }
        IPage<Book> page = new Page<>(currentPage,pageSize);
        bookDao.selectPage(page,lqw);
        return page;
    }
}
