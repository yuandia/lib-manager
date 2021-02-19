package com.example.demo.service.Impl;

import com.example.demo.dao.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    public Book getBook(String bookName) {
        return bookMapper.getBook(bookName);
    }

    public boolean setBook(Book book) {
        if(bookMapper.findBook(book.getBookName())==null){
            bookMapper.setBook(book);
            return true;
        }
        else return false;
    }

    @Override
    public boolean addBook(String bookName, int addbookNumber) {
        if(bookMapper.findBook(bookName)!=null){
            bookMapper.addBook(bookName,addbookNumber);
            return true;
        }
        else return false;
    }

    public boolean deleteBook(String bookName){
        if(bookMapper.findBook(bookName)!=null){
            bookMapper.deleteBook(bookName);
            return true;
        }
        else return false;
    }
}
