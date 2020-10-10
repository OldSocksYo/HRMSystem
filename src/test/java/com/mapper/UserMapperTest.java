package com.mapper;

import com.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/19 22:54
 */
public class UserMapperTest {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void findUserByUsername() {
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        User user = userMapper.findUserByUsername("王也");
        System.out.println(user);
    }
}