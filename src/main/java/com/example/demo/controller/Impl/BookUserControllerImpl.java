package com.example.demo.controller.Impl;

import com.example.demo.controller.BookUserController;
import com.example.demo.dao.User;
import com.example.demo.service.BookUserService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class BookUserControllerImpl implements BookUserController{

    @Autowired
    private BookUserService bookUserService;

    public String barrowBook(){
        return null;
    }
}
