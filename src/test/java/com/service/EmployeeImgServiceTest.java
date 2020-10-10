package com.service;

import com.domain.EmployeeImg;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.SocketException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/28 8:49
 */
public class EmployeeImgServiceTest {
    private ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void insertEmployeeImg() {
        EmployeeImgService employeeImgService = ac.getBean("employeeImgService", EmployeeImgService.class);
        EmployeeImg employeeImg = new EmployeeImg();
        employeeImg.setId(2);
        employeeImg.setImgUrl("http://localhost:8081/HRM/pictures/e1c6464e35ec4c7387faf17506c86990-baobao.png");
        employeeImgService.insertEmployeeImg(employeeImg);
    }

    @Test
    public void deleteEmployeeImgById() {
        EmployeeImgService employeeImgService = ac.getBean("employeeImgService", EmployeeImgService.class);
        employeeImgService.deleteEmployeeImgById(2);
    }

    @Test
    public void updateEmployeeImgById() {
    }

    @Test
    public void findEmployeeImgById() {
        EmployeeImgService employeeImgService = ac.getBean("employeeImgService", EmployeeImgService.class);
        EmployeeImg employeeImgById = employeeImgService.findEmployeeImgById(2);
        System.out.println(employeeImgById);
    }

    @Test
    public void findAllEmployeeImg() {
        EmployeeImgService employeeImgService = ac.getBean("employeeImgService", EmployeeImgService.class);
        List<EmployeeImg> allEmployeeImg = employeeImgService.findAllEmployeeImg();
        allEmployeeImg.forEach(System.out::println);
    }

    @Test
    public void updateUrl() throws SocketException {
        EmployeeImgService employeeImgService = ac.getBean("employeeImgService", EmployeeImgService.class);
        employeeImgService.updateURL(null, null);
    }
}