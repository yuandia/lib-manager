package com.example.demo.controller;

import com.example.demo.dao.Book;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/Book")
public interface BookController {

    @RequestMapping("/getBookList")
    List<Book> getBookList();

    @RequestMapping("/getBook")
    Book getBook(String bookName);

    @RequestMapping("/setBook")
    String setBook(String bookName);

    @RequestMapping("/addBook")
    String addBook(String bookName,int addbookNumber);

    @RequestMapping("/deleteBook")
    String deleteBook(String bookName);
}
