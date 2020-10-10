package com.service.impl;

import com.domain.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 11:51
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int deleteEmployeeById(Integer id) {
        return employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        return employeeMapper.updateEmployeeById(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeMapper.findEmployeeById(id);
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(Integer departmentId) {
        return employeeMapper.findEmployeeByDepartmentId(departmentId);
    }

    @Override
    public PageInfo<Employee> findAllEmployee(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> employees = employeeMapper.findAllEmployee();
        //清理TheadLocal存储的分页数据，以保证线程安全
//        PageHelper.clearPage();
        return new PageInfo<>(employees);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeMapper.findAllEmployee();
    }
}
