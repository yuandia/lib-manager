package com.example.demo.mapper;

import com.example.demo.dao.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    Book findBook(@Param("bookName") String bookName);//查询数据库中是否含有该书
    List<Book> getBookList();

    Book getBook(String bookName);

    void setBook(Book book);

    void addBook(@Param("bookName") String bookName, @Param("addbookNumber") int addbookNumber);

    void deleteBook(@Param("bookName") String bookName);
}
