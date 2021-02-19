package com.example.demo.controller.Impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;

    public List<User> getUserList(){
        return userService.getUserList();
    }

    public User getUser(String account){
        return userService.getUser(account);
    }

    public String regist(@Param("userName") String userName,
                         @Param("userAccount") String userAccount,
                         @Param("userPassword") String userPassword){
        User user=new User(userName,userAccount,userPassword);
        if(userService.regist(user)){
            return "注册成功！"+"注册人："+user.getUserName()+" 账号："+user.getUserAccount()+"密码："+user.getUserPassword();
        }
        else return "该用户已存在";
    }

    public Result<String> dologin(HttpServletResponse response,
                                  @RequestParam("userAccount") String userAccount,
                                  @RequestParam("userPassword") String userPassword) {
        //登录
        log.info("用户登录：userName:{}, userPassword:{}", userAccount, userPassword);

        //判断用户名是否存在
        String token=userService.login(response,userAccount,userPassword);
        return Result.success(token);
    }

    public String delete(@Param("userName") String userName,
                         @Param("userAccount") String userAccount,
                         @Param("userPassword") String userPassword){
        User user=new User(userName,userAccount,userPassword);
        if(userService.delete(user)){
            return "注销成功，注销账号为："+user.getUserAccount();
        }
        else return "该用户不存在或密码错误无法注销";
    }

    public String quitLogin(User user) {
        return null;
    }

    public Result<User> current(User user) {
        return Result.success(user);
    }
}
