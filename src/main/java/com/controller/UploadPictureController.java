package com.controller;

import com.domain.Employee;
import com.domain.EmployeeImg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.DeleteFileUtils;
import utils.AddressOperateUtils;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 用来处理上传员工图片相关的Controller
 * @Author: Yong
 * @CreateDate: 2020/9/28 14:37
 */
@Controller
@RequestMapping("/uploadPic")
public class UploadPictureController extends BaseController{

    /**
     * 根据id查询员工信息，并以json方式返回
     * @param id
     * @return
     */
    @RequestMapping("/getEmployee")
    @ResponseBody
    public Employee getEmployee(Integer id) {
        Employee employeeImgById = employeeService.findEmployeeById(id);
        return employeeImgById;
    }

    /**
     * 以json的方式返回所有员工的信息
     * @return
     */
    @RequestMapping("/getAllEmployees")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployee();
    }

    /**
     * 上传员工图片
     * @return
     */
    @PostMapping("uploadPicture")
    public String uploadPicture(@RequestParam("picture") MultipartFile picture, @RequestParam("id") Integer id, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/pictures/");
        System.out.println("realPath=" + realPath);
        File file = new File(realPath);
        //判断文件是否存在
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        if(picture.isEmpty()){
            return "manage/uploadPicture";
        }
        String pictureOriginalFilename = picture.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String pictureName = uuid + "-" + pictureOriginalFilename ;

        EmployeeImg employeeImgById = employeeImgService.findEmployeeImgById(id);
        //删除服务器和数据库中员工原来的图片信息
        if(employeeImgById != null){
            String theLastOfUrl = StringUtils.getTheLastOfUrl(employeeImgById.getImgUrl());
            DeleteFileUtils.deleteFile(realPath + theLastOfUrl);
            employeeImgService.deleteEmployeeImgById(id);
        }
        System.out.println("request.getServerName()=" + request.getServerName());
        //上传的图片的存储位置
        String picturePath = request.getScheme()
                + "://"
//                + request.getServerName()
                //获取当前服务器的ip地址
                + AddressOperateUtils.getLocalIpv4()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/"
                + "pictures/";
        picture.transferTo(new File(realPath, pictureName));
        System.out.println("picturePath + pictureName=" + picturePath + pictureName);

        EmployeeImg employeeImg = new EmployeeImg();
        employeeImg.setId(id);
        employeeImg.setImgUrl(picturePath + pictureName);
        employeeImgService.insertEmployeeImg(employeeImg);

        request.setAttribute("image", employeeImg.getImgUrl());
        return "manage/uploadPicture";
    }


    @RequestMapping("getEmployeePic")
    @ResponseBody
    public EmployeeImg getEmployeePic(@RequestParam(value = "id") Integer id){
        EmployeeImg employeeImgById = employeeImgService.findEmployeeImgById(id);
        return employeeImgById;
    }

    /**
     * 获取所有员工的图片
     * @return
     */
    @RequestMapping("getAllEmployeePic")
    @ResponseBody
    public List<EmployeeImg> getAllEmployeePic(){
        return employeeImgService.findAllEmployeeImg();
    }

    /**
     * 更新数据库中员工图片的请求地址
     * @param response
     * @param ip 前端传入的ip地址（当自动获取出错的情况下使用）
     */
    @GetMapping("/updatePicturesUrl")
    public void updatePicturesUrl(HttpServletResponse response, HttpServletRequest request, String ip) throws SocketException {
        employeeImgService.updateURL(ip, String.valueOf(request.getServerPort()));
        try {
            if(ip != null){
                //上传的图片的存储位置
                String UrlPath = request.getScheme()
                        + "://"
//                + request.getServerName()
                        //获取当前服务器的ip地址
                        + ip
                        + ":"
                        + request.getServerPort()
                        + request.getContextPath()
                        + "/";
                response.getWriter().write("<h1>" + UrlPath + "</h1>");
            }else {
                //上传的图片的存储位置
                String UrlPath = request.getScheme()
                        + "://"
//                + request.getServerName()
                        //获取当前服务器的ip地址
                        + AddressOperateUtils.getLocalIpv4()
                        + ":"
                        + request.getServerPort()
                        + request.getContextPath()
                        + "/";
                response.getWriter().write("<h1>" + UrlPath + "</h1>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
