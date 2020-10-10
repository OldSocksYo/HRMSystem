package com.service;

import com.domain.User;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 11:46
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 查到的用户的实体类
     */
    User findUserByUsername(String username);

}
