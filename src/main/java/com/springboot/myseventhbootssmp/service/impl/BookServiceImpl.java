package com.springboot.myseventhbootssmp.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.springboot.myseventhbootssmp.dao.BookDao;
import com.springboot.myseventhbootssmp.domain.Book;
import com.springboot.myseventhbootssmp.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
