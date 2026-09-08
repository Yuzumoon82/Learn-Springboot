package com.springboot.myseventhbootssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.spring.service.IService;
import com.springboot.myseventhbootssmp.domain.Book;

public interface IBookService extends IService<Book> {
    boolean delete(Integer id);
    boolean modify(Book book);
    IPage<Book> getPage(int currentPage, int pageSize);
}
