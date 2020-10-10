package com.mapper;

import com.domain.Department;
import com.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 11:15
 */
public class DepartmentMapperTest {

    ClassPathXmlApplicationContext ac;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void insertDepartment() {
        DepartmentMapper departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");
        Department department = new Department(1, "人事部", "北京");
        int rt = departmentMapper.insertDepartment(department);
        System.out.println(rt);
    }

    @Test
    public void deleteDepartmentById() {
        DepartmentMapper departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");
        int rt = departmentMapper.deleteDepartmentById(1);
        System.out.println(rt);
    }

    @Test
    public void updateDepartmentById() {
        DepartmentMapper departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");
        Department department = new Department(1, "技术兜底部", "上海");
        int rt = departmentMapper.updateDepartmentById(department);
        System.out.println(rt);
    }

    @Test
    public void findDepartmentById() {
        DepartmentMapper departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");
        Department departmentById = departmentMapper.findDepartmentById(1);
        System.out.println(departmentById);
    }

    @Test
    public void findAllDepartment() {
        DepartmentMapper departmentMapper = (DepartmentMapper) ac.getBean("departmentMapper");
        List<Department> allDepartment = departmentMapper.findAllDepartment();
        allDepartment.forEach(System.out::println);
    }
}