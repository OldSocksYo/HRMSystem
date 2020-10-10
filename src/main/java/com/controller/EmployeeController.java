package com.controller;

import com.domain.Department;
import com.domain.Employee;
import com.domain.EmployeeImg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.DeleteFileUtils;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/21 23:39
 */
@Controller
public class EmployeeController extends BaseController {
    /**
     * 根据当前页和一页的大小，获取一页的信息
     * @param pageNum 当前页号
     * @param pageSize 一页的大小
     * @return 返回存有分页相关信息的PageInfo对象
     */
    public PageInfo<Employee> getEmpPageInfo(Integer pageNum, Integer pageSize){
        System.out.println("pageNum=" + pageNum + ",pageSize=" + pageSize);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 9;
        }
        return employeeService.findAllEmployee(pageNum, pageSize);
    }

    /**
     * 判断部门是否存在
     * @param id 前端传入的部门id号
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("isExistDepartment")
    @ResponseBody
    public String isExistDepartment(Integer id) throws JsonProcessingException {
        Department departmentById = departmentService.findDepartmentById(id);
        HashMap<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if(departmentById == null){
            map.put("isExist", "false");
        }else {
            map.put("isExist", "true");
        }

        return mapper.writeValueAsString(map);
    }

    /**
     * 获取所有的员工信息
     * @param request
     * @return 返回所有员工信息
     */
    @RequestMapping("/getEmployees")
    public String getEmployees(HttpServletRequest request,
                                @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                @RequestParam(defaultValue = "9", value = "pageSize") Integer pageSize){
        PageInfo<Employee> employeePageInfo = getEmpPageInfo(pageNum, pageSize);
        request.getSession().setAttribute("empPageNum", pageNum);
        request.getSession().setAttribute("empPageSize", pageSize);
        System.out.println("ThreadName:" + Thread.currentThread().getName());
        request.setAttribute("employeePageInfo", employeePageInfo);
        return "manage/employee-main";
    }

    /**
     * 操作后，请求主页，定位到原来数据所处的页面
     * @param request
     * @return
     */
    @RequestMapping("getEmployeesFromCurrentPage")
    public String getEmployeesFromCurrentPage(HttpServletRequest request){
        Integer empPageNum =(Integer) request.getSession().getAttribute("empPageNum");
        Integer empPageSize =(Integer) request.getSession().getAttribute("empPageSize");
        PageInfo<Employee> employeePageInfo = getEmpPageInfo(empPageNum, empPageSize);
        request.setAttribute("employeePageInfo", employeePageInfo);
        return "manage/employee-main";
    }

    /**
     * 根据员工id获取指定的员工信息
     * @param request
     * @param id 员工id
     * @return
     */
    @RequestMapping("getEmployee")
    public String getEmployee(HttpServletRequest request, Integer id){
        Employee employeeById = employeeService.findEmployeeById(id);
        request.setAttribute("changeEmployee", employeeById);
        return "manage/employee-change";
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value="changeEmployee")
    @ResponseBody
    public String changeEmployee( Employee employee) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int rtn = employeeService.updateEmployeeById(employee);
        HashMap<String, String> map = new HashMap<>();
        if(rtn > 0){
            map.put("changeFlag", "true");
        }else {
            map.put("changeFlag", "false");
        }
        System.out.println("changeEmployee()方法");
        return mapper.writeValueAsString(map);
    }

    /**
     * 添加新的员工
     * @param employee 将要添加的员工的信息
     * @return 返回是否添加成功的标志信息
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "addEmployee")
    @ResponseBody
    public String addEmployee(Employee employee) throws JsonProcessingException {
        int rtn = employeeService.insertEmployee(employee);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        if(rtn > 0){
            map.put("addFlag", "true");
        }else {
            map.put("addFlag", "false");
        }
        System.out.println("addEmployee()方法");
        return mapper.writeValueAsString(map);
    }

    /**
     * 删除操作请求的控制器
     * @param request
     * @param id 前端传入的将要删除的员工的id号
     * @return 返回到删除前的员工信息页
     */
    @RequestMapping("deleteEmployee")
    @ResponseBody
    public String deleteEmployee(HttpServletRequest request, Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        int rtn = employeeService.deleteEmployeeById(id);
        if(rtn > 0){
            map.put("deleteFlag", "true");
        }else {
            map.put("deleteFlag", "false");
        }
        //删除员工对应的图片信息
        String realPath = request.getSession().getServletContext().getRealPath("/pictures/");
        EmployeeImg employeeImgById = employeeImgService.findEmployeeImgById(id);
        //删除服务器和数据库中员工原来的图片信息
        if(employeeImgById != null){
            String theLastOfUrl = StringUtils.getTheLastOfUrl(employeeImgById.getImgUrl());
            DeleteFileUtils.deleteFile(realPath + theLastOfUrl);
            employeeImgService.deleteEmployeeImgById(id);
        }

        System.out.println("deleteEmployee()方法");
        //加上redirect或者forward关键字后，不走视图解析器，不会自动进行拼串操作
        return mapper.writeValueAsString(map);
    }
}