package com.controller;

import com.service.DepartmentService;
import com.service.EmployeeImgService;
import com.service.EmployeeService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 12:20
 */
@Controller
public class BaseController {
    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeImgService employeeImgService;
}
