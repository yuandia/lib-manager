package com.example.demo.dao;

public class BookUser {
    private int id;
    private int bookId;
    private int userId;
    private String barrowTime;
    private String backTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBarrowTime() {
        return barrowTime;
    }

    public void setBarrowTime(String barrowTime) {
        this.barrowTime = barrowTime;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public BookUser() {
    }

    public BookUser(int id, int bookId, int userId, String barrowTime, String backTime) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.barrowTime = barrowTime;
        this.backTime = backTime;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", barrowTime='" + barrowTime + '\'' +
                ", backTime='" + backTime + '\'' +
                '}';
    }
}
