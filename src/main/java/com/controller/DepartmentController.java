package com.controller;

import com.domain.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/27 15:02
 */
@Controller
public class DepartmentController extends BaseController {
    public PageInfo<Department> getDepPageInfo(Integer pageNum, Integer pageSize){
        System.out.println("pageNum=" + pageNum + ",pageSize=" + pageSize);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 9;
        }
        return departmentService.findAllDepartment(pageNum, pageSize);
    }

    /**
     * 获取所有的部门信息
     * @param request
     * @return 返回部门信息
     */
    @RequestMapping("/getDepartments")
    public String getDepartments(HttpServletRequest request,
                                 @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                 @RequestParam(defaultValue = "9", value = "pageSize") Integer pageSize){
        PageInfo<Department> departmentPageInfo = departmentService.findAllDepartment(pageNum, pageSize);
        request.getSession().setAttribute("departmentPageNum", pageNum);
        request.getSession().setAttribute("departmentPageSize", pageSize);
        request.setAttribute("departmentPageInfo", departmentPageInfo);
        return "manage/department-main";
    }

    /**
     * 操作后，请求主页，定位到原来数据所处的页面
     * @param request
     * @return
     */
    @RequestMapping("getDepartmentsFromCurrentPage")
    public String getDepartmentsFromCurrentPage(HttpServletRequest request){
        Integer departmentPageNum =(Integer) request.getSession().getAttribute("departmentPageNum");
        Integer departmentPageSize =(Integer) request.getSession().getAttribute("departmentPageSize");
        PageInfo<Department> departmentPageInfo = getDepPageInfo(departmentPageNum, departmentPageSize);
        request.setAttribute("departmentPageInfo", departmentPageInfo);
        return "manage/department-main";
    }

    @RequestMapping("getDepartment")
    public String getDepartment(HttpServletRequest request, Integer id){
        Department departmentById = departmentService.findDepartmentById(id);
        request.setAttribute("changeDepartment", departmentById);
        return "manage/department-change";
    }

    @RequestMapping("changeDepartment")
    @ResponseBody
    public String changeDepartment(Department department) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int rtn = departmentService.updateDepartmentById(department);
        HashMap<String, String> map = new HashMap<>();
        if(rtn > 0){
            map.put("changeFlag", "true");
        }else {
            map.put("changeFlag", "false");
        }
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("addDepartment")
    @ResponseBody
    public String addDepartment(Department department) throws JsonProcessingException {
        int rtn = departmentService.insertDepartment(department);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        if(rtn > 0){
            map.put("addFlag", "true");
        }else {
            map.put("addFlag", "false");
        }
        return mapper.writeValueAsString(map);
    }

    @RequestMapping("deleteDepartment")
    @ResponseBody
    public String deleteDepartment(HttpServletRequest request, Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        int rtn = departmentService.deleteDepartmentById(id);
        if(rtn > 0){
            map.put("deleteFlag", "true");
        }else {
            map.put("deleteFlag", "false");
        }
        return mapper.writeValueAsString(map);
    }
}
