package com.springboot.myseventhbootssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.spring.service.IService;
import com.springboot.myseventhbootssmp.domain.Book;
import org.springframework.context.annotation.Bean;

public interface IBookService extends IService<Book> {
    boolean delete(Integer id);
    boolean modify(Book book);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
