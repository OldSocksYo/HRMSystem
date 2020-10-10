package com.mapper;

import com.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/19 23:07
 */
public class EmployeeMapperTest {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
       ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void insertEmployee() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        Employee employee = new Employee(1, 1, "张楚岚", "男", "12345678910", "zhangchulan@126.com");
        int rt = employeeMapper.insertEmployee(employee);
        System.out.println(rt);
    }

    @Test
    public void deleteEmployeeById() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        int rt = employeeMapper.deleteEmployeeById(1);
        System.out.println(rt);
    }

    @Test
    public void updateEmployeeById() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        Employee employee = new Employee(1, 1, "张楚岚", "男", "12345678910", "zhangchulan@126.com");
        int rt = employeeMapper.updateEmployeeById(employee);
        System.out.println(rt);
    }

    @Test
    public void findEmployeeById() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        Employee employeeById = employeeMapper.findEmployeeById(1);
        System.out.println(employeeById);
    }

    @Test
    public void findEmployeeByDepartmentId() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        List<Employee> employeeByDepartmentId = employeeMapper.findEmployeeByDepartmentId(1);
        System.out.println(employeeByDepartmentId);
    }

    @Test
    public void findAllEmployee() {
        EmployeeMapper employeeMapper = (EmployeeMapper) ac.getBean("employeeMapper");
        List<Employee> allEmployee = employeeMapper.findAllEmployee();
        allEmployee.forEach(System.out::println);
    }
}