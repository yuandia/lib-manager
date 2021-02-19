package com.example.demo.dao;

public class Book {
    private int bookId;
    private String bookName;
    private String createTime;
    private int bookInventory;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(int bookInventory) {
        this.bookInventory = bookInventory;
    }

    public Book() {
    }

    public Book(int bookId, String bookName, String createTime, int bookInventory) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.createTime = createTime;
        this.bookInventory = bookInventory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", bookInventory=" + bookInventory +
                '}';
    }
}
