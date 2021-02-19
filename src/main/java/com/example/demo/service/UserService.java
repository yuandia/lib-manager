package com.example.demo.service;

import com.example.demo.dao.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUser(String account);

    boolean regist(User user);

    String login(HttpServletResponse response, String userAccount, String userPassword);

    User findByUserAccount(String userAccount);

    User getByToken(HttpServletResponse response,String token);

    boolean delete(User user);
}
