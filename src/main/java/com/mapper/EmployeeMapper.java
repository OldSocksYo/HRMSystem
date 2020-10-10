package com.mapper;

import com.domain.Employee;

import java.util.List;

/**
 * @Description: 员工信息DAO
 * @Author: Yong
 * @CreateDate: 2020/9/18 16:41
 */
public interface EmployeeMapper {
    /**
     * 增加新的员工
     * @param employee 将要添加的员工的实体类
     * @return 返回影响的数据库中数据的行数
     */
    int insertEmployee(Employee employee);

    /**
     * 根据员工id删除员工信息
     * @param id 员工id
     * @return 返回影响的数据库数据的行数
     */
    int deleteEmployeeById(Integer id);

    /**
     * 根据员工id修改员工信息
     * @param employee 修改后的员工对应的实体类
     * @return 返回影响的数据库数据的行数
     */
    int updateEmployeeById(Employee employee);

    /**
     * 根据员工id查询员工
     * @param id 员工id
     * @return 返回查询的员工信息并封装到Employee实体类中
     */
    Employee findEmployeeById(Integer id);

    /**
     * 根据部门id查询员工信息
     * @param departmentId 部门id
     * @return 返回查询到的员工信息，封装到Employee实体类中并放入List集合
     */
    List<Employee> findEmployeeByDepartmentId(Integer departmentId);

    /**
     * 查询所有的员工信息
     * @return 返回数据库中所有的员工的信息
     */
    List<Employee> findAllEmployee();
}
