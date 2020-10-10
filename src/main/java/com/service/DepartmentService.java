package com.service;

import com.domain.Department;
import com.domain.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 11:48
 */
public interface DepartmentService {
    /**
     * 插入新的部门信息
     * @param department 部门信息对应的实体类
     * @return 返回影响的数据库数据的行数
     */
    int insertDepartment(Department department);

    /**
     * 根据部门号删除部门
     * @param departmentId 将要删除的部门的id
     * @return 返回影响的数据库数据的行数
     */
    int deleteDepartmentById(Integer departmentId);

    /**
     * 根据部门id修改部门信息
     * @param department 修改后的部门信息对应的实体类
     * @return 返回影响的数据库数据的行数
     */
    int updateDepartmentById(Department department);

    /**
     * 根据部门id查询部门信息
     * @param departmentId 部门id
     * @return 返回查询到的部门信息对应的实体类
     */
    Department findDepartmentById(Integer departmentId);

    /**
     * 查询所有部门信息
     * @return 返回数据库中所有的部门的信息
     */
    PageInfo<Department> findAllDepartment(Integer pageNum, Integer pageSize);
}
