package com.springboot.myseventhbootssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.myseventhbootssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
