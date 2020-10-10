package com.mapper;

import com.domain.User;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/19 20:50
 */
public interface UserMapper {
    /**
     * 根据用户名查找用户
     * @param username 将要查找的用户
     * @return 返回查找到的用户对应的实体类
     */
    User findUserByUsername(String username);
}
