package com.example.demo.service;

import com.example.demo.dao.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();

    Book getBook(String bookName);

    boolean setBook(Book book);

    boolean addBook(String bookName,int addbookNumber);

    boolean deleteBook(String bookName);
}
