package com.example.demo.controller.Impl;

import com.example.demo.controller.BookController;
import com.example.demo.dao.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class BookControllerImpl implements BookController{

    @Autowired
    private BookService bookService;

    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    public Book getBook(String bookName){
        return bookService.getBook(bookName);
    }

    public String setBook(String bookName){
        Book book = new Book();
        book.setBookName(bookName);
        Calendar cal=Calendar.getInstance();
        String creatTime=cal.get(cal.YEAR)+"-"+(cal.get(cal.MONTH)+1)+"-"+cal.get(cal.DAY_OF_MONTH);
        book.setCreateTime(creatTime);
        book.setBookInventory(0);
        if(bookService.setBook(book)){
            return "放书成功！书名为："+book.getBookName()+"创建时间："+creatTime;
        }
        else return "该书已存在";
    }

    public String addBook(String bookName,int addbookNumber) {
        if(bookService.addBook(bookName,addbookNumber)){
            return "放书成功，书名："+bookName+" 库存增加："+addbookNumber;
        }
        else return "该书不存在，请先将书名加入数据库";
    }

    public String deleteBook(String bookName){
        if(bookService.deleteBook(bookName)){
            return "删书成功！书名为："+bookName;
        }
        return "该书不存在或已被删除";
    }
}