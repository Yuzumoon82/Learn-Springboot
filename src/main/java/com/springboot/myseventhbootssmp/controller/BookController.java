//当前真正使用的接口控制器

package com.springboot.myseventhbootssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.myseventhbootssmp.controller.utils.R;
import com.springboot.myseventhbootssmp.domain.Book;
import com.springboot.myseventhbootssmp.service.BookService;
import com.springboot.myseventhbootssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private BookService bookService;

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
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("Sunmoon")) throw new IOException();
        boolean flag = iBookService.save(book);
        return new R(flag,flag?"操作成功 😄":"操作失败 😭");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.modify(book));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = iBookService.getPage(currentPage,pageSize,book);
//        如果当前页码值大于总页码值，重新执行查询分页，将最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = iBookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
