package com.example.demo.controller;

import com.example.demo.dao.User;
import com.example.demo.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/User")
public interface UserController {
    @RequestMapping("/getList")
    List<User> getUserList();

    @RequestMapping("/getAccount")
    User getUser(String account);

    @PostMapping("/regist")
    String regist(String userName,
                  String userAccount,
                  String userPassword);

    @RequestMapping("/dologin")
    Result<String> dologin(HttpServletResponse response, String userAccount, String userPassword);

    @PostMapping("/delete")
    String delete(String userName,
                  String userAccount,
                  String userPassword);

    @RequestMapping("/delLogin")
    String quitLogin(User user);

    @RequestMapping("/current")
    @ResponseBody
    Result<User> current(User user);
}
