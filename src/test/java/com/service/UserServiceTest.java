package com.service;

import com.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 12:05
 */
public class UserServiceTest {

    ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void findUserByUsername() {
        UserService userService = (UserService) ac.getBean("userService");
        User user = userService.findUserByUsername("王也");
        System.out.println(user);
    }
}