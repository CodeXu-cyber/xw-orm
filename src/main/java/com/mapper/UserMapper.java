package com.mapper;

import com.entity.User;

import java.util.List;

/**
 * @author xuwei
 */
public interface UserMapper {
    /**
     * 查询所有
     *
     * @return List
     */
    List<User> findAll();

    /**
     * 查询单个
     *
     * @param id
     * @return User
     */
    User findById(Integer id);

    /**
     * 更新操作
     *
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * 添加操作
     *
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * 删除操作
     *
     * @param id
     * @return int
     */
    int deleteUser(Integer id);
}
