package com.service;

import com.domain.Employee;
import com.mapper.EmployeeMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 12:05
 */
public class EmployeeServiceTest {

    ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void insertEmployee() {
        EmployeeService employeeService = (EmployeeService) ac.getBean("employeeService");
    }

    @Test
    public void deleteEmployeeById() {
    }

    @Test
    public void updateEmployeeById() {
    }

    @Test
    public void findEmployeeById() {
        EmployeeService employeeService = (EmployeeService) ac.getBean("employeeService");
        Employee employeeById = employeeService.findEmployeeById(1);
        System.out.println(employeeById);
    }

    @Test
    public void findEmployeeByDepartmentId() {
    }

    @Test
    public void findAllEmployee() {
    }
}