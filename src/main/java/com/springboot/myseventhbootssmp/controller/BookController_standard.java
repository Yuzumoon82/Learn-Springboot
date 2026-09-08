package com.springboot.myseventhbootssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.myseventhbootssmp.domain.Book;
import com.springboot.myseventhbootssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController_standard {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){
        return iBookService.list();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return iBookService.delete(id);
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return iBookService.modify(book);
    }

    @GetMapping
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return iBookService.getPage(currentPage,pageSize);
    }
}
