package com.example.demo.mapper;

import com.example.demo.dao.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getUserList();

    User getUser(@Param("userAccount") String userAccount);

    void regist(User user);
    User findAccount(@Param("userAccount") String userAccount);

    void delete(User user);
    User findAccount2(User user);
}
