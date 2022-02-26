package com.mapper;

import com.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);
    int updateUser(User user);
    int addUser(User user);
    int deleteUser(Integer id);
}
