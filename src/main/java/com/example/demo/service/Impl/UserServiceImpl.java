package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.Util.RedisUtil;
import com.example.demo.dao.User;
import com.example.demo.exception.GlobalException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.result.CodeMsg;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    public List<User> getUserList(){
        return userMapper.getUserList();
    }

    public User getUser(String account){
        return userMapper.getUser(account);
    }

    public boolean regist(User user){
        if(userMapper.findAccount(user.getUserAccount())==null){
            userMapper.regist(user);
            return true;
        }
        else return false;
    }

    public static final String CooKIE_NAME_TOKEN="token";
    public static final int TOKEN_EXPIRE=3600*24*2;
    public User findByUserAccount(String userAccount){
        return userMapper.findAccount(userAccount);
    }
    public String login(HttpServletResponse response, String userAccount, String userPassword) {
        User user=findByUserAccount(userAccount);
        if(user==null){
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        String dbPass=user.getUserPassword();
        if(!userPassword.equals(dbPass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token= UUID.randomUUID().toString().replace("-","");
        addCookie(response,token,user);
        return token;
    }
    public User getByToken(HttpServletResponse response,String token){
        if(StringUtils.isEmpty(token)){
            return null;
        }
        User user= JSON.parseObject(redisUtil.get(CooKIE_NAME_TOKEN+"::"+token),User.class);
        //重置有效期
        if(user==null){
            throw new GlobalException(CodeMsg.USER_NOT_LOGIN);
        }
        addCookie(response,token,user);
        return user;
    }
    private void addCookie(HttpServletResponse response,String token,User user){
        //将token存入到redis
        redisUtil.set(CooKIE_NAME_TOKEN+"::"+token,JSON.toJSONString(user),TOKEN_EXPIRE);
        //将token写入cookie
        Cookie cookie=new Cookie(CooKIE_NAME_TOKEN,token);
        cookie.setMaxAge(TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public boolean delete(User user){
        if(userMapper.findAccount2(user)!=null){
            userMapper.delete(user);
            return true;
        }
        else return false;
    }
}
