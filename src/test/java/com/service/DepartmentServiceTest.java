package com.service;

import com.domain.Department;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 12:05
 */
public class DepartmentServiceTest {

    ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void insertDepartment() {
    }

    @Test
    public void deleteDepartmentById() {
    }

    @Test
    public void updateDepartmentById() {
    }

    @Test
    public void findDepartmentById() {
        DepartmentService departmentService = (DepartmentService) ac.getBean("departmentService");
        Department departmentById = departmentService.findDepartmentById(1);
        System.out.println(departmentById);
    }

    @Test
    public void findAllDepartment() {
    }
}