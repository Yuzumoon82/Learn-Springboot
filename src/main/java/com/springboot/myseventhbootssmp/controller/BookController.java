package com.springboot.myseventhbootssmp.controller;

import com.springboot.myseventhbootssmp.controller.utils.R;
import com.springboot.myseventhbootssmp.domain.Book;
import com.springboot.myseventhbootssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
//        R r = new R();
//        boolean flag = iBookService.delete(id);
//        r.setFlag(flag);
        return new R(iBookService.delete(id));
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.modify(book));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true,iBookService.getPage(currentPage,pageSize));
    }
}
