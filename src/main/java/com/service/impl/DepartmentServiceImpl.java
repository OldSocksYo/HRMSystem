package com.service.impl;

import com.domain.Department;
import com.domain.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DepartmentMapper;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 11:59
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public int deleteDepartmentById(Integer departmentId) {
        return departmentMapper.deleteDepartmentById(departmentId);
    }

    @Override
    public int updateDepartmentById(Department department) {
        return departmentMapper.updateDepartmentById(department);
    }

    @Override
    public Department findDepartmentById(Integer departmentId) {
        return departmentMapper.findDepartmentById(departmentId);
    }

    @Override
    public PageInfo<Department> findAllDepartment(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> departments = departmentMapper.findAllDepartment();
        return new PageInfo<>(departments);
    }
}
