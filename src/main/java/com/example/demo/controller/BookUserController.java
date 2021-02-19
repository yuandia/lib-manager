package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/BookUser")
public interface BookUserController {
    String barrowBook();
}
